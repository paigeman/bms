package com.test.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.service.IReaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestReaderService {

    @Autowired
    private IReaderService iReaderService;

    @Test
    public void testAddReader(){
        Reader reader = new Reader();
        reader.setReader_id("ReaderTest6");
        reader.setReader_name("王五");
        reader.setReader_sex("男");
        reader.setReader_contact("820-820-8820");
        reader.setReader_image("/WEB-INF/statics/images/default.png");
        reader.setReader_register_time(new Date());
        reader.setReader_last_sign_time(new Date());
        reader.setReader_pwd("123456789");
        if(iReaderService.addReader(reader)){
            System.out.println("增加读者成功！");
        }
        else{
            System.out.println("增加读者失败！");
        }
    }

    @Test
    public void testIsReader(){
        //错误的reader_id
        //String reader_id = "王五";
        String reader_id = "ReaderTest";
        //正确的reader_pwd
        //String reader_pwd = "123456789";
        String reader_pwd = "1234567890";
        if(iReaderService.isReader(reader_id,reader_pwd)){
            System.out.println("欢迎您"+reader_id+"！");
        }
        else{
            System.out.println("对不起，您输入的密码不正确或者该用户不存在！");
        }
    }

    @Test
    public void testIsBan(){
        String reader_id = "ReaderTest";
        if(iReaderService.isBan(reader_id)){
            System.out.println("该用户已被封禁！");
        }
        else{
            System.out.println("该用户未被封禁！");
        }
    }

    @Test
    public void testIsSetBan(){
        String reader_id = "ReaderTest";
        if(iReaderService.isSetBan(reader_id)){
            System.out.println("该用户已被成功封禁！");
        }
        else{
            System.out.println("封禁失败！");
        }
    }

    @Test
    public void testIsUpdate(){
        Reader reader = new Reader();
        reader.setReader_id("ReaderTest");
        reader.setReader_last_sign_time(new Date());
        if(iReaderService.isUpdate(reader)){
            System.out.println("读者信息已被更新！");
        }
        else{
            System.out.println("更新失败！");
        }
    }

    @Test
    public void testIsUpdateFine(){
        String reader_id = "ReaderTest";
        Float reader_fine = new Float(39.50);
        if(iReaderService.isUpdateFine(reader_id,reader_fine)){
            System.out.println("更新罚款成功！");
        }
        else{
            System.out.println("更新罚款失败！");
        }
    }

    @Test
    public void testDeleteReader(){
        String reader_id = "ReaderTest";
        if(iReaderService.deleteReader(reader_id)){
            System.out.println("删除成功！");
        }
        else{
            System.out.println("删除失败！");
        }
    }

    @Test
    public void testQueryAllReader(){
        PageInfo<Reader> page = iReaderService.queryAllReader(1,5);
//        page.
        List<Reader> list = page.getList();
        for (Reader i:list
             ) {
            System.out.println(i);
            System.out.println(i.getReader_id()+"\t"+i.getReader_name());
        }
        System.out.println(page);
    }

    @Test
    public void testQueryReaderByAttribute(){
        PageInfo<Reader> page = iReaderService.queryReaderByAttribute(1,5,"reader_sex","女","reader_sex = ");
        List<Reader> list = page.getList();
        for (Reader i:list
        ) {
            System.out.println(i);
            System.out.println(i.getReader_id()+"\t"+i.getReader_name());
        }
        System.out.println(page);
    }

    @Test
    public void testQueryReaderByAttributeBetween(){
        PageInfo<Reader> page = iReaderService.queryReaderByAttributeBetween(1,5,"reader_fine",30.00,60.00,"reader_fine between ");
        List<Reader> list = page.getList();
        for (Reader i:list
        ) {
            System.out.println(i);
            System.out.println(i.getReader_id()+"\t"+i.getReader_name());
        }
        System.out.println(page);
    }

    @Test
    public void testQueryReaderByAttributeNull(){
        PageInfo<Reader> page = iReaderService.queryReaderByAttributeNull(1,5,"reader_fine is null");
        List<Reader> list = page.getList();
        for (Reader i:list
        ) {
            System.out.println(i);
            System.out.println(i.getReader_id()+"\t"+i.getReader_name());
        }
        System.out.println(page);
    }

}
