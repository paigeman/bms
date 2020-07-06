package com.ncu.bms.service;

import com.ncu.bms.bean.Admin;

public interface IAdminService {

    /*增加管理员*/
    //public boolean addAdmin(Admin admin);

    /*删除管理员*/
    //public boolean deleteAdmin(String admin_id);

    /*是否是管理员*/
    public boolean isAdmin(String admin_id,String admin_pwd);

    /*是否存在该用户*/
    public Admin isExist(String admin_id);

    /*账户是否被ban*/
    //public boolean isBan(String admin_id);

    /*封禁管理员*/
    //public boolean isSetBan(String admin_id);

    /*更新信息*/
    public boolean isUpdate(Admin admin);

    /*修改管理员密码*/
    public boolean isChangePwd(String admin_id,String admin_pwd);

}
