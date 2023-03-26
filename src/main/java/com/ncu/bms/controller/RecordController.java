package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Record;
import com.ncu.bms.service.IRecordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private IRecordService iRecordService;

    @RequestMapping(value = "/borrow")
    @ResponseBody
    public String borrowBook(HttpSession session, @RequestBody JSONObject data){
//        System.out.println("enter");
//        return "false";
        String book_No = data.getString("book_No");
//        System.out.println(book_No);
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("admin")){
            //System.out.println("enter");
            return "false";
        }
        else{
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null||reader_id.equals("")){
                //System.out.println("enter");
                return "false";
            }
            else{
                String admin_id = "root";
                Date record_borrow = new Date();
                Record record = new Record();
                record.setRecord_book(book_No);
                record.setRecord_reader(reader_id);
                record.setRecord_admin(admin_id);
                record.setRecord_borrow(record_borrow);
                if(iRecordService.isAddRecord(record)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

    @RequestMapping(value = "querySpecificReader")
    @ResponseBody
    public PageInfo<Record> querySpecificReader(HttpSession session,@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue = "5")int size){
//        System.out.println("enter");
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("admin")){
//            System.out.println("enter");
            return null;
        }
        else{
//            System.out.println("enter");
            String reader_id = (String) session.getAttribute("id");
//            System.out.println("enter");
            if(reader_id==null||reader_id.equals("")){
                System.out.println("enter");
                return null;
            }
            else{
                PageInfo<Record> page = iRecordService.queryRecordByAttribute(offset,size,"record_reader",reader_id,"record_reader =");
                return page;
            }
        }
    }

    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public PageInfo<Record> queryAll(HttpSession session,@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue = "5")int size){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return null;
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return null;
            }
            else{
                PageInfo<Record> page = iRecordService.queryAllRecord(offset,size);
//                Record record = new Record();
//                record.setRecord_is_lost(new Integer(0));
//                PageInfo<Record> page = iRecordService.queryRecordByExample(offset,size,record);
                return page;
            }
        }
    }

    @RequestMapping(value = "/queryWant")
    @ResponseBody
    public PageInfo<Record> queryWant(HttpSession session,@RequestBody JSONObject data,@RequestParam(defaultValue = "1") int offset,@RequestParam(defaultValue = "5") int size){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return null;
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return null;
            }
            else{
                String record_book = (String)data.get("record_book");
                String record_reader = (String)data.get("record_reader");
                Integer record_is_return;
                Integer record_is_overtime;
                Record record = new Record();
//                if(data.get("record_is_return")==null){
//                    record_is_return = new Integer(0);
//                }
//                else{
//                    record_is_return = new Integer((String) data.get("record_is_return"));
//                }
                if(data.get("record_is_return")!=null){
                    record_is_return = new Integer((String) data.get("record_is_return"));
                    record.setRecord_is_return(record_is_return);
                }
//                if(data.get("record_is_overtime")==null){
//                    record_is_overtime = new Integer(0);
//                }
//                else{
//                    record_is_overtime = new Integer((String)data.get("record_is_overtime"));
//                }
                if(data.get("record_is_overtime")!=null){
                    record_is_overtime = new Integer((String)data.get("record_is_overtime"));
                    record.setRecord_is_overtime(record_is_overtime);
                }
                if(record_book!=null&&!record_book.equals("")){
                    record.setRecord_book(record_book);
                }
                if(record_reader!=null&&!record_reader.equals("")){
                    record.setRecord_reader(record_reader);
                }
//                record.setRecord_is_lost(new Integer(0));

                PageInfo<Record> page = iRecordService.queryRecordByExample(offset,size,record);
                return page;
            }
        }
    }

    @RequestMapping(value = "/return")
    @ResponseBody
    public String returnBook(HttpSession session,@RequestParam Integer record_id){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
                if(iRecordService.isSetReturnTime(record_id,new Date())&&iRecordService.isSetReturn(record_id)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

    @RequestMapping(value = "/setLost")
    @ResponseBody
    public String setLost(HttpSession session,@RequestParam Integer record_id){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
                if(iRecordService.isSetLost(record_id)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteBook(HttpSession session,@RequestParam Integer record_id){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
                if(iRecordService.isDeleteRecord(record_id)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

}
