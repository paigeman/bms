package com.ncu.bms.service.impl;

import com.ncu.bms.bean.Admin;
import com.ncu.bms.bean.AdminExample;
import com.ncu.bms.dao.AdminMapper;
import com.ncu.bms.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean isAdmin(String admin_id,String admin_pwd) {
        Admin admin = isExist(admin_id);
        if(admin==null){
            return false;
        }
        else{
            String tmp_admin_pwd = admin.getAdmin_pwd();
            if(tmp_admin_pwd.equals(admin_pwd)){
                return true;
            }
            return false;
        }
    }

    @Override
    public Admin isExist(String admin_id) {
        //Admin admin = null;
        //Admin模板
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdmin_idEqualTo(admin_id);
        //查询管理员，也可以用下面的方法
        //如此便不需要创建Admin模板，处理逻辑可以省略
        //admin = adminMapper.selectByPrimaryKey(admin_id);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if(list.size()==0){
            return null;
        }
        else{
            //理论上说有且仅有一个
            return list.get(0);
        }
    }

    @Override
    public boolean isUpdate(Admin admin) {
        int result = adminMapper.updateByPrimaryKeySelective(admin);
        if(result!=0){
            //result为1表示更新成功,0表示更新失败
            //System.out.println(result);
            return true;
        }
        return false;
    }

    @Override
    public boolean isChangePwd(String admin_id, String admin_pwd) {
        Admin admin = new Admin();
        admin.setAdmin_id(admin_id);
        admin.setAdmin_pwd(admin_pwd);
        if(isUpdate(admin)){
            return true;
        }
        return false;
    }

}
