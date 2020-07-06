package com.test.service;

import com.ncu.bms.bean.Admin;
import com.ncu.bms.service.IAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAdminService {

    @Autowired
    private IAdminService iAdminService;

    @Test
    public void testIsExist(){
        Admin admin = iAdminService.isExist("root");
        if(admin==null){
            System.out.println("此管理员不存在！");
        }
        else{
            System.out.println("此管理员已被查找到！\tadmin_id="+admin.getAdmin_id()+"\tadmin_name="+admin.getAdmin_name());
        }
    }

    @Test
    public void testIsAdmin(){
        String admin_id = "root";
        //错误密码
        //String admin_pwd = "afga111";
        //正确密码
        String admin_pwd = "123456789";
        if(iAdminService.isAdmin(admin_id,admin_pwd)){
            System.out.println("欢迎您，管理员"+admin_id+"!");
        }
        else{
            System.out.println("对不起，您输入的密码错误，请重试！");
        }
    }

    @Test
    public void testIsUpdate(){
        Admin admin = new Admin();
        admin.setAdmin_id("root");
        admin.setAdmin_name("李四");
        admin.setAdmin_sex("女");
        if(iAdminService.isUpdate(admin)){
            System.out.println("更新成功！");
        }
        else{
            System.out.println("更新失败！");
        }
    }

    @Test
    public void testIsChangePwd(){
        String admin_id = "root";
        String admin_pwd = "987654321";
        if(iAdminService.isChangePwd(admin_id,admin_pwd)){
            System.out.println("更新成功！");
        }
        else{
            System.out.println("更新失败！");
        }
    }

}
