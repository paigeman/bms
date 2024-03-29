package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.service.IReaderService;
import com.ncu.bms.util.JWTUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    private final IReaderService iReaderService;

    public ReaderController(IReaderService iReaderService) {
        this.iReaderService = iReaderService;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public String readerLogin(HttpSession session, @RequestBody JSONObject data) {
    //public void readerLogin(HttpServletResponse response,@RequestParam String reader_id,@RequestParam String reader_pwd){
        String reader_id = (String) data.get("reader_id");
        String tmp_reader_pwd = (String) data.get("reader_pwd");
        Reader reader = iReaderService.isExist(reader_id);
        try {
            if(reader==null){
                return "false";
            }
            else{
                String reader_pwd = reader.getReader_pwd();
                if(!reader_pwd.equals(tmp_reader_pwd)){
                    return "false";
                }
                else{
                    Map<String,Object> map = new HashMap<>(8);
                    map.put("reader_id",reader_id);
                    map.put("reader_pwd",reader_pwd);
                    String token = JWTUtil.createToken(map);
                    session.setAttribute("token",token);
                    session.setAttribute("who","reader");
                    session.setAttribute("id",reader_id);
                    return "true";
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String readerRegister(@RequestBody JSONObject data){
        String reader_id = (String) data.get("reader_id");
        String reader_name = (String)data.get("reader_name");
        String reader_sex = (String)data.get("reader_sex");
        String reader_contact = (String)data.get("reader_contact");
        String reader_image = "/WEB-INF/statics/images/default.png";
        Date reader_register_time = new Date();
        Date reader_last_sign_time = new Date();
        String reader_pwd = (String)data.get("reader_pwd");
        Reader reader = new Reader();
        reader.setReader_id(reader_id);
        reader.setReader_name(reader_name);
        reader.setReader_sex(reader_sex);
        reader.setReader_contact(reader_contact);
        reader.setReader_image(reader_image);
        reader.setReader_register_time(reader_register_time);
        reader.setReader_last_sign_time(reader_last_sign_time);
        reader.setReader_pwd(reader_pwd);
        if(iReaderService.addReader(reader)){
            return "true";
        }
        else{
            return "false";
        }
    }

    @RequestMapping(value = "/profile")
    @ResponseBody
    public Reader queryReader(HttpSession session){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "admin".equals(who)){
            return null;
        }
        else{
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null|| "".equals(reader_id)){
                return null;
            }
            else{
                return iReaderService.isExist(reader_id);
            }
        }
    }

    @RequestMapping(value = "/updateProfile")
    @ResponseBody
    public String updateProfile(HttpSession session,@RequestBody JSONObject data){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "admin".equals(who)){
            return "false";
        }
        else{
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null|| "".equals(reader_id)){
                return "false";
            }
            else{
                Reader reader = iReaderService.isExist(reader_id);
                if(reader==null){
                    return "false";
                }
                else{
                    String tmp_reader_contact = (String)data.get("reader_contact");
                    String tmp_reader_pwd = (String)data.get("reader_pwd");
                    boolean result = reader.getReader_pwd().equals(tmp_reader_pwd);
                    reader.setReader_contact(tmp_reader_contact);
                    reader.setReader_pwd(tmp_reader_pwd);
                    if(iReaderService.isUpdate(reader)){
                        if(result){
                            return "contact success";
                        }
                        else{
                            return "pwd success";
                        }
                    }
                    else{
                        return "false";
                    }
                }
            }
        }
    }

}
