package com.test.service;

import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Book;
import com.ncu.bms.service.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestBookService {

    @Autowired
    private IBookService iBookService;

    @Test
    public void testIsDelete(){
        String book_No = "BookTest";
        if(iBookService.isDeleteBook(book_No)){
            System.out.println("删除成功！");
        }
        else{
            System.out.println("删除失败！");
        }
    }

    @Test
    public void testQueryBookByExample(){
        Book book = new Book();
        //book.setBook_name("网络安全");
        //book.setBook_publisher("清华大学出版社");
        book.setBook_number(new Integer(1));
        PageInfo<Book> page = iBookService.queryBookByExample(1,5,book);
        List<Book> list = page.getList();
        for (Book i: list
             ) {
            System.out.println(i.getBook_No());
        }
        System.out.println(page);
        //PageInfo{pageNum=1, pageSize=5, size=2, startRow=1, endRow=2, total=2, pages=1, list=Page{count=true, pageNum=1, pageSize=5, startRow=0, endRow=5, total=2, pages=1, reasonable=true, pageSizeZero=true}, prePage=0, nextPage=0, isFirstPage=true, isLastPage=true, hasPreviousPage=false, hasNextPage=false, navigatePages=8, navigateFirstPage1, navigateLastPage1, navigatepageNums=[1]}
    }

}
