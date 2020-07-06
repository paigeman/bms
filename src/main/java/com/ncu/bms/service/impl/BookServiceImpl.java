package com.ncu.bms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Book;
import com.ncu.bms.bean.BookExample;
import com.ncu.bms.dao.BookMapper;
import com.ncu.bms.service.IBookService;
import com.ncu.bms.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private IRecordService iRecordService;

    @Override
    public boolean isAddBook(Book book) {
        String book_No = book.getBook_No();
        if(isBookExist(book_No)!=null){
            return false;
        }
        else{
            if(bookMapper.insertSelective(book)!=0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public boolean isDeleteBook(String book_No) {
        Book book = isBookExist(book_No);
        if(book!=null){
            if(iRecordService.queryRecordByAttribute(1,5,"record_book",
                    book.getBook_No(),"record_book =")!=null){
                isSetBan(book_No);
                return true;
            }
            else{
                if(bookMapper.deleteByPrimaryKey(book_No)!=0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }

    @Override
    public Book isBookExist(String book_No) {
        Book book = bookMapper.selectByPrimaryKey(book_No);
        if(book!=null){
            return book;
        }
        return null;
    }

    @Override
    public boolean isBookBan(String book_No) {
        Book book = isBookExist(book_No);
        if(book!=null){
            if(book.getBook_ban()==0){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int getBookLimit(String book_No) {
        Book book = isBookExist(book_No);
        if(book==null){
            return -1;
        }
        else{
            int limit = book.getBook_limit();
            return limit;
        }
    }

    @Override
    public PageInfo<Book> queryAllBook(int offset, int size) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBook_NoIsNotNull();
        PageHelper.startPage(offset,size);
        List<Book> pageList = bookMapper.selectByExample(bookExample);
        PageInfo<Book> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Book> queryBookByAttribute(int offset, int size, String attributeName, Object attributeValue, String condition) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBook_NoIsNotNull().addCriterion(condition,attributeValue,attributeName);
        PageHelper.startPage(offset,size);
        List<Book> pageList = bookMapper.selectByExample(bookExample);
        PageInfo<Book> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Book> queryBookByAttributeBetween(int offset, int size, String attributeName, Object attributeValue1, Object attributeValue2, String condition) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBook_NoIsNotNull().addCriterion(condition,attributeValue1,attributeValue2,attributeName);
        PageHelper.startPage(offset,size);
        List<Book> pageList = bookMapper.selectByExample(bookExample);
        PageInfo<Book> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Book> queryBookByAttributeNull(int offset, int size, String condition) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andBook_NoIsNotNull().addCriterion(condition);
        PageHelper.startPage(offset,size);
        List<Book> pageList = bookMapper.selectByExample(bookExample);
        PageInfo<Book> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public PageInfo<Book> queryBookByExample(int offset, int size, Book book) {
        PageHelper.startPage(offset,size);
        List<Book> pageList = bookMapper.selectByBookSelective(book);
        PageInfo<Book> page = new PageInfo<>(pageList);
        return page;
    }

    @Override
    public boolean isSetBan(String book_No) {
        Book book = isBookExist(book_No);
        if(book!=null){
            book.setBook_ban(new Integer(1));
            if(bookMapper.updateByPrimaryKeySelective(book)!=0){
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

    @Override
    public boolean isUpdateBookInfo(Book book) {
        String book_No = book.getBook_No();
        if(isBookExist(book_No)!=null){
            if(bookMapper.updateByPrimaryKeySelective(book)!=0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public float queryPerDay(String book_No) {
        Book book = isBookExist(book_No);
        if(book!=null){
            float book_per_day = book.getBook_per_day();
            return book_per_day;
        }
        return 0;
    }

}
