package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ncu.bms.bean.Admin;
import com.ncu.bms.service.IAdminService;
import com.ncu.bms.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String amdinLogin(HttpSession session,@RequestBody JSONObject data){
        String admin_id = (String)data.get("admin_id");
        String tmp_admin_pwd = (String)data.get("admin_pwd");
        Admin admin = iAdminService.isExist(admin_id);
        if(admin==null){
            return "false";
        }
        else{
            String admin_pwd = admin.getAdmin_pwd();
            if(!admin_pwd.equals(tmp_admin_pwd)){
                return "false";
            }
            else{
                Map<String,Object> map = new HashMap<>();
                map.put("admin_id",admin_id);
                map.put("admin_pwd",admin_pwd);
                String token = JWTUtil.createToken(map);
                session.setAttribute("token",token);
                session.setAttribute("who","admin");
                session.setAttribute("id",admin_id);
                return "true";
            }
        }
    }

    @RequestMapping(value = "/profile")
    @ResponseBody
    public Admin queryAdmin(HttpSession session){
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
                Admin admin = iAdminService.isExist(admin_id);
                if(admin==null){
                    return null;
                }
                else{
                    return admin;
                }
            }
        }
    }

    @RequestMapping(value = "/updateProfile")
    @ResponseBody
    public String updateProfile(HttpSession session,@RequestBody JSONObject data){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            //System.out.println("enter");
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
                Admin admin = iAdminService.isExist(admin_id);
                if(admin==null){
                    return "false";
                }
                else{
                    String tmp_admin_contact = (String)data.get("admin_contact");
                    String tmp_admin_pwd = (String)data.get("admin_pwd");
                    boolean result = admin.getAdmin_pwd().equals(tmp_admin_pwd);
                    admin.setAdmin_contact(tmp_admin_contact);
                    admin.setAdmin_pwd(tmp_admin_pwd);
                    if(iAdminService.isUpdate(admin)){
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
