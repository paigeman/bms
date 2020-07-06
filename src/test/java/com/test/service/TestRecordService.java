package com.test.service;

import com.ncu.bms.bean.Record;
import com.ncu.bms.service.IRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRecordService {

    @Autowired
    private IRecordService iRecordService;

    @Test
    public void testAddRecord(){
        Record record = new Record();
        record.setRecord_book("BookTest");
        record.setRecord_reader("ReaderTest");
        record.setRecord_admin("root");
        record.setRecord_borrow(new Date());
        if(iRecordService.isAddRecord(record)){
            System.out.println("增加记录成功！");
        }
        else{
            System.out.println("增加记录失败！");
        }
    }

    @Test
    public void testIsSetReturnTime(){
        Integer record_id = new Integer(1);
        Date tmp_record_return = new Date();
        Date record_return = new Date(tmp_record_return.getTime()+(long)((long)24*60*60*1000*31));
        if(iRecordService.isSetReturnTime(record_id,record_return)){
            System.out.println("设置归还时间成功！");
        }
        else{
            System.out.println("设置归还时间失败！");
        }
        System.out.println(tmp_record_return.getTime());
        System.out.println(record_return.getTime());
        System.out.println(tmp_record_return.getTime()+(24*60*60*1000*31));
        System.out.println((long)((long)24*60*60*1000*31));
    }

    @Test
    public void testIsOverTime(){
        Integer record_id = new Integer(1);
        if(iRecordService.isOverTime(record_id)){
            System.out.println("借书已超时！");
        }
        else{
            System.out.println("借书未超时！");
        }
    }

}
