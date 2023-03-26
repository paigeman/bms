package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.ncu.bms.bean.Admin;
import com.ncu.bms.service.IAdminService;
import com.ncu.bms.util.JWTUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fade
 * @date 2023/03/26
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final IAdminService iAdminService;

    public AdminController(IAdminService iAdminService) {
        this.iAdminService = iAdminService;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String amdinLogin(HttpSession session,@RequestBody JSONObject data){
        String adminId = (String)data.get("admin_id");
        String tmpAdminPwd = (String)data.get("admin_pwd");
        Admin admin = iAdminService.isExist(adminId);
        if(admin==null){
            return "false";
        }
        else{
            String adminPwd = admin.getAdmin_pwd();
            if(!adminPwd.equals(tmpAdminPwd)){
                return "false";
            }
            else{
                Map<String,Object> map = new HashMap<>(8);
                map.put("admin_id",adminId);
                map.put("admin_pwd",adminPwd);
                String token = JWTUtil.createToken(map);
                session.setAttribute("token",token);
                session.setAttribute("who","admin");
                session.setAttribute("id",adminId);
                return "true";
            }
        }
    }

    @RequestMapping(value = "/profile")
    @ResponseBody
    public Admin queryAdmin(HttpSession session){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            return null;
        }
        else{
            String adminId = (String) session.getAttribute("id");
            if(adminId ==null|| "".equals(adminId)){
                return null;
            }
            else{
                return iAdminService.isExist(adminId);
            }
        }
    }

    @RequestMapping(value = "/updateProfile")
    @ResponseBody
    public String updateProfile(HttpSession session,@RequestBody JSONObject data){
        String who = (String)session.getAttribute("who");
        if(who==null|| "".equals(who)|| "reader".equals(who)){
            //System.out.println("enter");
            return "false";
        }
        else{
            String adminId = (String) session.getAttribute("id");
            if(adminId ==null|| "".equals(adminId)){
                return "false";
            }
            else{
                Admin admin = iAdminService.isExist(adminId);
                if(admin==null){
                    return "false";
                }
                else{
                    String tmpAdminContact = (String)data.get("admin_contact");
                    String tmpAdminPwd = (String)data.get("admin_pwd");
                    boolean result = admin.getAdmin_pwd().equals(tmpAdminPwd);
                    admin.setAdmin_contact(tmpAdminContact);
                    admin.setAdmin_pwd(tmpAdminPwd);
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
