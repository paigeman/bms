package com.ncu.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.bean.ReaderExample;
import com.ncu.bms.dao.ReaderMapper;
import com.ncu.bms.service.IReaderService;
import com.ncu.bms.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderServiceImpl implements IReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private IRecordService iRecordService;

    @Override
    public Reader isExist(String reader_id) {
        Reader reader = readerMapper.selectByPrimaryKey(reader_id);
        return reader;
    }

    @Override
    public boolean isReader(String reader_id, String reader_pwd) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return false;
        }
        else{
            String tmp_reader_pwd = reader.getReader_pwd();
            if(tmp_reader_pwd.equals(reader_pwd)){
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean addReader(Reader reader) {
        String reader_id = reader.getReader_id();
        if(isExist(reader_id)!=null){
            return false;
        }
        else{
            if(readerMapper.insertSelective(reader)!=0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public boolean isBan(String reader_id) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return false;
        }
        else{
            int ban = reader.getReader_ban();
            if(ban==0){
                return false;
            }
            else{
                return true;
            }
        }
    }

    @Override
    public boolean isSetBan(String reader_id) {
        Reader reader = new Reader();
        reader.setReader_id(reader_id);
        reader.setReader_ban(new Integer(1));
        if(readerMapper.updateByPrimaryKeySelective(reader)==0){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean isUpdate(Reader reader) {
        int result = readerMapper.updateByPrimaryKeySelective(reader);
        if(result!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isUpdateFine(String reader_id, Float reader_fine) {
        Reader reader = new Reader();
        reader.setReader_id(reader_id);
        reader.setReader_fine(reader_fine);
        if(readerMapper.updateByPrimaryKeySelective(reader)!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReader(String reader_id) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return false;
        }
        else{
            if(iRecordService.queryRecordByAttribute(1,5,"record_id"
                    ,reader.getReader_id(),"record_id = ")!=null){
                isSetBan(reader_id);
                return true;
            }
            else{
                int result = readerMapper.deleteByPrimaryKey(reader_id);
                if(result!=0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }

    @Override
    public Date queryReaderRegisterTime(String reader_id) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return null;
        }
        else{
            Date date = reader.getReader_register_time();
            return date;
        }
    }

    @Override
    public Date queryReaderLastSignTime(String reader_id) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return null;
        }
        else{
            Date date = reader.getReader_last_sign_time();
            return date;
        }
    }

    @Override
    public boolean isChangeLastSignTime(String reader_id, Date reader_last_sign_time) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return false;
        }
        else{
            reader.setReader_last_sign_time(reader_last_sign_time);
            if(readerMapper.updateByPrimaryKeySelective(reader)!=0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public boolean isChangePwd(String reader_id, String reader_pwd) {
        Reader reader = isExist(reader_id);
        if(reader==null){
            return false;
        }
        else{
            reader.setReader_pwd(reader_pwd);
            if(readerMapper.updateByPrimaryKeySelective(reader)!=0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public long countReaderNum() {
        ReaderExample readerExample = new ReaderExample();
        readerExample.createCriteria().andReader_idIsNotNull();
        long result = readerMapper.countByExample(readerExample);
        if(result!=0){
            return result;
        }
        return 0;
    }

    @Override
    public PageInfo<Reader> queryAllReader(int offset,int size) {
        ReaderExample readerExample = new ReaderExample();
        readerExample.createCriteria().andReader_idIsNotNull();
        PageHelper.startPage(offset, size);
        List<Reader> pageList = readerMapper.selectByExample(readerExample);
        PageInfo<Reader> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Reader> queryReaderByAttribute(int offset, int size, String attributeName, Object attributeValue,String condition) {
        ReaderExample readerExample = new ReaderExample();
        readerExample.createCriteria().andReader_idIsNotNull().addCriterion(condition,attributeValue,attributeName);
        PageHelper.startPage(offset,size);
        List<Reader> pageList = readerMapper.selectByExample(readerExample);
        PageInfo<Reader> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Reader> queryReaderByAttributeBetween(int offset, int size, String attributeName,
                                                          Object attributeValue1, Object attributeValue2, String condition) {

        ReaderExample readerExample = new ReaderExample();
        readerExample.createCriteria().andReader_idIsNotNull().addCriterion(condition,attributeValue1,attributeValue2,attributeName);
        PageHelper.startPage(offset,size);
        List<Reader> pageList = readerMapper.selectByExample(readerExample);
        PageInfo<Reader> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Reader> queryReaderByAttributeNull(int offset, int size, String condition) {
        ReaderExample readerExample = new ReaderExample();
        readerExample.createCriteria().andReader_idIsNotNull().addCriterion(condition);
        PageHelper.startPage(offset,size);
        List<Reader> pageList = readerMapper.selectByExample(readerExample);
        PageInfo<Reader> page = new PageInfo<>(pageList);
        return page;
    }

}
