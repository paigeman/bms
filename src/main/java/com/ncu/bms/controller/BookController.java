package com.ncu.bms.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ncu.bms.bean.Book;
import com.ncu.bms.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @RequestMapping(value = "/queryWant")
    @ResponseBody
    public PageInfo<Book> queryWant(@RequestBody JSONObject data,@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue = "4")int size){
        //System.out.println(offset+"\t"+size);
        //System.out.println("enter");
//        System.out.println(data);
//        System.out.println(data.getString("book_number"));
        String book_category = (String)data.get("book_category");
//        System.out.println(book_category);
        String book_name = (String) data.get("book_name");
//        System.out.println(book_name);
        String book_author = (String)data.get("book_author");
//        System.out.println("book_author");
        String book_publisher = (String)data.get("book_publisher");
//        System.out.println(book_publisher);
        Integer book_number;
        if(data.get("book_number")==null){
            book_number = new Integer(0);
        }
        else{
            book_number = Integer.parseInt((String) data.get("book_number"));
        }
        //Float book_price = (Float)data.get("book_price");
        //Integer book_number = (Integer)data.get("book_number");
        String book_price = (String) data.get("book_price");
//        System.out.println(book_price);
//        Integer book_number = Integer.parseInt(data.getString(""))
        //System.out.println(book_category+"\t"+book_name+"\t"+book_author+"\t"+book_publisher+"\t"+book_price+"\t"+book_number);
        Book book = new Book();
        if(book_category!=null&&!book_category.equals("")){
            book.setBook_category(book_category);
        }
        if(book_name!=null&&!book_name.equals("")){
            book.setBook_name(book_name);
        }
        if(book_category!=null&&!book_category.equals("")){
            book.setBook_category(book_category);
        }
        if(book_author!=null&&!book_author.equals("")){
            book.setBook_author(book_author);
        }
        if(book_publisher!=null&&!book_publisher.equals("")){
            book.setBook_publisher(book_publisher);
        }
        if(book_price!=null&&!book_price.equals("")){
            book.setBook_price(Float.parseFloat(book_price));
        }
        book.setBook_number(book_number);
//        System.out.println(book);
        PageInfo<Book> page = iBookService.queryBookByExample(offset,size,book);
//        System.out.println(page);
        return page;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteBook(HttpSession session, @RequestBody JSONObject data){
//        System.out.println("enter");
        String book_No = data.getString("book_No");
        String who = (String)session.getAttribute("who");
//        System.out.println("enter");
        if(who==null||who.equals("")||who.equals("reader")){
            //System.out.println("enter");
            return "false";
        }
        else {
//            System.out.println("enter");
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                //System.out.println("enter");
                return "false";
            }
            else{
//                System.out.println("enter");
                if(iBookService.isDeleteBook(book_No)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

    @RequestMapping(value = "/info")
    @ResponseBody
    public Book showBookInfo(HttpSession session){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            return null;
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return null;
            }
            else{
                String book_No = (String)session.getAttribute("book_No");
                Book book = iBookService.isBookExist(book_No);
                if(book==null){
                    return null;
                }
                else {
                    return book;
                }
            }
        }
    }

    @RequestMapping(value = "/updateInfo")
    @ResponseBody
    public String updateBookInfo(HttpSession session,@RequestBody JSONObject data){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            //System.out.println("enter");
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
//                System.out.println("enter");
                String book_No = (String)session.getAttribute("book_No");
//                System.out.println(data.get("book_No"));
//                System.out.println(book_No);
                Book book = iBookService.isBookExist(book_No);
                if(book==null){
                    return "false";
                }
                else{
//                    System.out.println("enter");
                    String book_name = (String)data.get("book_name");
                    String book_author = (String)data.get("book_author");
                    String book_publisher = (String)data.get("book_publisher");
                    String book_bio = (String)data.get("book_bio");
                    String book_category = (String)data.get("book_category");
                    String book_price = (String)data.get("book_price");
                    String book_number = (String)data.get("book_number");
                    String book_ban = (String)data.get("book_ban");
                    String book_limit = (String)data.get("book_limit");
                    String book_per_day = (String)data.get("book_per_day");
                    book_price = book_price.split("元")[0];
                    book_ban = ((book_ban.equals("是"))?"1":"0");
                    book_limit = book_limit.split("天")[0];
                    book_per_day = book_per_day.split("元")[0];
                    book.setBook_name(book_name);
                    book.setBook_author(book_author);
                    book.setBook_publisher(book_publisher);
                    book.setBook_bio(book_bio);
                    book.setBook_category(book_category);
                    book.setBook_price(new Float(book_price));
                    book.setBook_number(new Integer(book_number));
                    book.setBook_ban(new Integer(book_ban));
                    book.setBook_limit(new Integer(book_limit));
                    book.setBook_per_day(new Float(book_per_day));
//                    System.out.println(book_price+"\t"+book_ban+"\t"+book_limit+"\t"+book_per_day);
                    if(iBookService.isUpdateBookInfo(book)){
                        return "true";
                    }
                    else{
                        return "false";
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String addBook(HttpSession session,@RequestBody JSONObject data){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("reader")){
            //System.out.println("enter");
            return "false";
        }
        else{
            String admin_id = (String) session.getAttribute("id");
            if(admin_id==null||admin_id.equals("")){
                return "false";
            }
            else{
//                System.out.println("enter");
                Book book = new Book();
                String book_No = (String)data.get("book_No");
                String book_name = (String)data.get("book_name");
                String book_author = (String)data.get("book_author");
                String book_publisher = (String)data.get("book_publisher");
                String book_bio = (String)data.get("book_bio");
                String book_category = (String)data.get("book_category");
                String book_price = (String)data.get("book_price");
                String book_number = (String)data.get("book_number");
                String book_limit = (String)data.get("book_limit");
                String book_per_day = (String)data.get("book_per_day");
                System.out.println("enter");
                book.setBook_No(book_No);
                book.setBook_name(book_name);
                book.setBook_author(book_author);
                book.setBook_publisher(book_publisher);
                book.setBook_bio(book_bio);
                book.setBook_category(book_category);
                book.setBook_price(new Float(book_price));
                book.setBook_number(new Integer(book_number));
                book.setBook_limit(new Integer(book_limit));
                book.setBook_per_day(new Float(book_per_day));
                book.setBook_image("/images/default-book.png");
//                System.out.println("enter");
                if(iBookService.isAddBook(book)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
        }
    }

}
