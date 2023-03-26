package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Record;
import com.ncu.bms.service.IRecordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/record")
public class RecordController {

    private final IRecordService iRecordService;

    public RecordController(IRecordService iRecordService) {
        this.iRecordService = iRecordService;
    }

    @RequestMapping(value = "/borrow")
    @ResponseBody
    public String borrowBook(HttpSession session, @RequestBody JSONObject data){
        String bookNo = data.getString("book_No");
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "admin".equals(who)){
            return "false";
        }
        else{
            String readerId = (String) session.getAttribute("id");
            if(readerId==null|| "".equals(readerId)){
                return "false";
            }
            else{
                String adminId = "root";
                Date recordBorrow = new Date();
                Record record = new Record();
                record.setRecord_book(bookNo);
                record.setRecord_reader(readerId);
                record.setRecord_admin(adminId);
                record.setRecord_borrow(recordBorrow);
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
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "admin".equals(who)){
            return null;
        }
        else{
            String readerId = (String) session.getAttribute("id");
            if(readerId==null|| "".equals(readerId)){
                System.out.println("enter");
                return null;
            }
            else{
                return iRecordService.queryRecordByAttribute(offset,size,"record_reader",readerId,"record_reader =");
            }
        }
    }

    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public PageInfo<Record> queryAll(HttpSession session,@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue = "5")int size){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return null;
        }
        else{
            String adminId = (String) session.getAttribute("id");
            if(adminId==null|| "".equals(adminId)){
                return null;
            }
            else{
                return iRecordService.queryAllRecord(offset,size);
            }
        }
    }

    @RequestMapping(value = "/queryWant")
    @ResponseBody
    public PageInfo<Record> queryWant(HttpSession session,@RequestBody JSONObject data,@RequestParam(defaultValue = "1") int offset,@RequestParam(defaultValue = "5") int size){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return null;
        }
        else{
            String adminId = (String) session.getAttribute("id");
            if(adminId==null|| "".equals(adminId)){
                return null;
            }
            else{
                String recordBook = (String)data.get("record_book");
                String recordReader = (String)data.get("record_reader");
                Integer record_is_return;
                Integer record_is_overtime;
                Record record = new Record();
                if(data.get("record_is_return")!=null){
                    record_is_return = Integer.valueOf((String) data.get("record_is_return"));
                    record.setRecord_is_return(record_is_return);
                }
                if(data.get("record_is_overtime")!=null){
                    record_is_overtime = Integer.valueOf((String)data.get("record_is_overtime"));
                    record.setRecord_is_overtime(record_is_overtime);
                }
                if(recordBook!=null&&!"".equals(recordBook)){
                    record.setRecord_book(recordBook);
                }
                if(recordReader!=null&&!"".equals(recordReader)){
                    record.setRecord_reader(recordReader);
                }
                return iRecordService.queryRecordByExample(offset,size,record);
            }
        }
    }

    @RequestMapping(value = "/return")
    @ResponseBody
    public String returnBook(HttpSession session,@RequestParam Integer record_id){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null|| "".equals(admin_id)){
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
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null|| "".equals(admin_id)){
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
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null|| "".equals(admin_id)){
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
