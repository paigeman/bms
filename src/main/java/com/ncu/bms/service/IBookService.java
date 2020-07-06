package com.ncu.bms.service;

import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Book;

public interface IBookService {

    //增加图书
    public boolean isAddBook(Book book);

    //删除图书
    public boolean isDeleteBook(String book_No);

    //图书是否存在
    public Book isBookExist(String book_No);

    //图书是否下架
    public boolean isBookBan(String book_No);

    //图书的借阅时间是多少
    public int getBookLimit(String book_No);

    //查询所有书籍
    public PageInfo<Book> queryAllBook(int offset,int size);

    //根据图书模板查询书籍
    public PageInfo<Book> queryBookByExample(int offset,int size,Book book);

    //根据属性查询书籍 非between
    public PageInfo<Book> queryBookByAttribute(int offset,int size,String attributeName,Object attributeValue,String condition);

    //根据属性查询书籍 between
    public PageInfo<Book> queryBookByAttributeBetween(int offset,int size,String attributeName,
                                                      Object attributeValue1,Object attributeValue2,String condition);

    //根据属性查询书籍 null
    public PageInfo<Book> queryBookByAttributeNull(int offset,int size,String condition);

    //下架图书
    public boolean isSetBan(String book_No);

    //更新图书信息
    public boolean isUpdateBookInfo(Book book);

    //查询图书的每天罚款
    public float queryPerDay(String book_No);

}
