package com.ncu.bms.service;

import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Reader;

import java.util.Date;
import java.util.List;

public interface IReaderService {

    //增加读者
    public boolean addReader(Reader reader);

    //删除读者
    public boolean deleteReader(String reader_id);

    //读者是否存在
    public Reader isExist(String reader_id);

    //是否是该读者
    public boolean isReader(String reader_id,String reader_pwd);

    //查询所有读者
    public PageInfo<Reader> queryAllReader(int offset, int size);

    //根据属性查询读者 非between
    public PageInfo<Reader> queryReaderByAttribute(int offset,int size,String attributeName,Object attributeValue,String condition);

    //根据属性查询读者 between
    public PageInfo<Reader> queryReaderByAttributeBetween(int offset,int size,String attributeName,
                                                          Object attributeValue1,Object attributeValue2,String condition);

    //根据属性查询读者 null
    public PageInfo<Reader> queryReaderByAttributeNull(int offset,int size,String condition);

    //读者是否被ban
    public boolean isBan(String reader_id);

    //封禁读者
    public boolean isSetBan(String reader_id);

    //查询注册时间
    public Date queryReaderRegisterTime(String reader_id);

    //查询最后一次登录时间
    public Date queryReaderLastSignTime(String reader_id);

    //更新罚款
    public boolean isUpdateFine(String reader_id,Float reader_fine);

    //更新信息
    public boolean isUpdate(Reader reader);

    //修改密码
    public boolean isChangePwd(String reader_id,String reader_pwd);

    //统计读者数
    public long countReaderNum();

    //修改最后登录时间
    public boolean isChangeLastSignTime(String reader_id,Date reader_last_sign_time);

}
