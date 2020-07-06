package com.ncu.bms.service;

import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Record;

import java.util.Date;

public interface IRecordService {

    //增加记录
    public boolean isAddRecord(Record record);

    //删除记录
    public boolean isDeleteRecord(Integer record_id);

    //记录是否存在
    public Record isRecordExist(Integer record_id);

    //借书是否超时
    public boolean isOverTime(Integer record_id);

    //借书是否归还
    public boolean isReturn(Integer record_id);

    //获取接数时间
    public Date getBorrow(Integer record_id);

    //获取还书时间
    public Date getReturnTime(Integer record_id);

    //设置超时
    public boolean isSetOverTime(Integer record_id);

    //设置归还
    public boolean isSetReturn(Integer record_id);

    //设置归还时间
    public boolean isSetReturnTime(Integer record_id,Date record_return);

    //查询所有记录
    public PageInfo<Record> queryAllRecord(int offset,int size);

    //根据属性查询记录 非between
    public PageInfo<Record> queryRecordByAttribute(int offset,int size,String attributeName,Object attributeValue,String condition);

    //根据属性查询记录 between
    public PageInfo<Record> queryRecordByAttributeBetween(int offset,int size,String attributeName,
                                                          Object attributeValue1,Object attributeValue2,String condition);

    //根据属性查询记录 null
    public PageInfo<Record> queryRecordByAttributeNull(int offset,int size,String condition);

    //更新记录
    public boolean isUpdateRecord(Record record);

    //查询是否丢失
    public boolean isLost(Integer record_id);

    //设置丢失
    public boolean isSetLost(Integer record_id);

    public PageInfo<Record> queryRecordByExample(int offset,int size,Record record);

}
