package com.ncu.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Book;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.bean.Record;
import com.ncu.bms.bean.RecordExample;
import com.ncu.bms.dao.RecordMapper;
import com.ncu.bms.service.IAdminService;
import com.ncu.bms.service.IBookService;
import com.ncu.bms.service.IReaderService;
import com.ncu.bms.service.IRecordService;
import com.ncu.bms.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IAdminService iAdminService;

    @Autowired
    private IReaderService iReaderService;

    @Override
    public boolean isAddRecord(Record record) {
        Integer record_id = record.getRecord_id();
        if(isRecordExist(record_id)!=null){
            return false;
        }
        else{
            String admin_id = record.getRecord_admin();
            String reader_id = record.getRecord_reader();
            String book_No = record.getRecord_book();
            if((iAdminService.isExist(admin_id)!=null)&&(iReaderService.isExist(reader_id)!=null)&&
                    (iBookService.isBookExist(book_No)!=null)){
                Book book = iBookService.isBookExist(book_No);
                int book_number = book.getBook_number().intValue();
                if(book_number>=1){
                    book.setBook_number(new Integer(--book_number));
                    if(iBookService.isUpdateBookInfo(book)&&(recordMapper.insertSelective(record)!=0)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
    }

    @Override
    public boolean isDeleteRecord(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            int record_is_lost = record.getRecord_is_lost();
            int record_is_return = record.getRecord_is_return();
            if((record_is_lost!=0)&&(recordMapper.deleteByPrimaryKey(record_id)!=0)){
                return true;
            }
            else if((record_is_lost==0)&&(record_is_return==1)&&(recordMapper.deleteByPrimaryKey(record_id)!=0)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public Record isRecordExist(Integer record_id) {
        Record record = recordMapper.selectByPrimaryKey(record_id);
        if(record!=null){
            return record;
        }
        return null;
    }

    @Override
    public boolean isOverTime(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record==null){
            return false;
        }
        else{
            int record_is_overtime = record.getRecord_is_overtime();
            if(record_is_overtime==0){
                Date record_borrow = record.getRecord_borrow();
                //Date record_now = new Date();
                Date record_now = new Date();
                String book_No = record.getRecord_book();
                Book book = iBookService.isBookExist(book_No);
                int limit = book.getBook_limit();
                int day = TimeUtil.calculateDay(record_borrow,record_now);
                if(limit>=day){
                    return false;
                }
                else{
                    isSetOverTime(record.getRecord_id());
                    return true;
                }
            }
            else{
                return true;
            }
        }
    }

    @Override
    public boolean isReturn(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            int record_is_return = record.getRecord_is_return();
            if(record_is_return!=0){
                return true;
            }
            else{
                return false;
            }
        }
        //无记录返回true
        return true;
    }

    @Override
    public Date getBorrow(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            Date record_borrow = record.getRecord_borrow();
            return record_borrow;
        }
        return null;
    }

    @Override
    public Date getReturnTime(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            Date record_return = record.getRecord_return();
            return record_return;
        }
        return null;
    }

    @Override
    public boolean isSetOverTime(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            record.setRecord_is_overtime(new Integer(1));
            if(recordMapper.updateByPrimaryKeySelective(record)!=0){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isSetReturn(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            record.setRecord_is_return(new Integer(1));
            String book_No = record.getRecord_book();
            Book book = iBookService.isBookExist(book_No);
            int book_number = book.getBook_number();
            book.setBook_number(new Integer(++book_number));
            if((iBookService.isUpdateBookInfo(book))&&(recordMapper.updateByPrimaryKeySelective(record)!=0)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isSetReturnTime(Integer record_id, Date record_return) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            record.setRecord_return(record_return);
            Date record_borrow = record.getRecord_borrow();
            String book_No = record.getRecord_book();
            String reader_id = record.getRecord_reader();
            Book book = iBookService.isBookExist(book_No);
            Reader reader = iReaderService.isExist(reader_id);
            int book_limit = book.getBook_limit();
            int overtime = TimeUtil.calculateDay(record_borrow,record_return);
            if(book_limit<overtime){
                float tmp_reader_fine = (book.getBook_per_day().floatValue())*(overtime-book_limit);
                float reader_fine = reader.getReader_fine();
                reader_fine += tmp_reader_fine;
                reader.setReader_fine(new Float(reader_fine));
                if((iReaderService.isUpdate(reader))&&(recordMapper.updateByPrimaryKeySelective(record)!=0)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if(recordMapper.updateByPrimaryKeySelective(record)!=0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public PageInfo<Record> queryAllRecord(int offset, int size) {
        RecordExample recordExample = new RecordExample();
        recordExample.createCriteria().andRecord_idIsNotNull();
        PageHelper.startPage(offset, size);
        List<Record> pageList = recordMapper.selectByExample(recordExample);
        PageInfo<Record> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Record> queryRecordByAttribute(int offset, int size, String attributeName, Object attributeValue, String condition) {
        RecordExample recordExample = new RecordExample();
        recordExample.createCriteria().andRecord_idIsNotNull().addCriterion(condition,attributeValue,attributeName);
        PageHelper.startPage(offset, size);
        List<Record> pageList = recordMapper.selectByExample(recordExample);
        PageInfo<Record> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Record> queryRecordByAttributeBetween(int offset, int size, String attributeName, Object attributeValue1, Object attributeValue2, String condition) {
        RecordExample recordExample = new RecordExample();
        recordExample.createCriteria().andRecord_idIsNotNull().addCriterion(condition,attributeValue1,attributeValue2,attributeName);
        PageHelper.startPage(offset, size);
        List<Record> pageList = recordMapper.selectByExample(recordExample);
        PageInfo<Record> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Record> queryRecordByAttributeNull(int offset, int size, String condition) {
        RecordExample recordExample = new RecordExample();
        recordExample.createCriteria().andRecord_idIsNotNull().addCriterion(condition);
        PageHelper.startPage(offset, size);
        List<Record> pageList = recordMapper.selectByExample(recordExample);
        PageInfo<Record> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Record> queryRecordByExample(int offset, int size, Record record) {
        PageHelper.startPage(offset,size);
        List<Record> pageList = recordMapper.selectByRecordSelective(record);
        PageInfo<Record> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public boolean isUpdateRecord(Record record) {
        Integer record_id = record.getRecord_id();
        if(isRecordExist(record_id)!=null){
            if(recordMapper.updateByPrimaryKeySelective(record)!=0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean isLost(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            int record_is_lost = record.getRecord_is_lost();
            if(record_is_lost!=0){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isSetLost(Integer record_id) {
        Record record = isRecordExist(record_id);
        if(record!=null){
            record.setRecord_is_lost(new Integer(1));
            String reader_id = record.getRecord_reader();
            String book_No = record.getRecord_book();
            Reader reader = iReaderService.isExist(reader_id);
            float reader_fine = reader.getReader_fine();
            Book book = iBookService.isBookExist(book_No);
            float book_price = book.getBook_price();
            reader_fine += book_price;
            reader.setReader_fine(new Float(reader_fine));
            if((iReaderService.isUpdate(reader))&&(recordMapper.updateByPrimaryKeySelective(record)!=0)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

}
