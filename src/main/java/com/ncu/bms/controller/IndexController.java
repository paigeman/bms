package com.ncu.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/view")
public class IndexController {

    @RequestMapping(value = "/index")
    public String showIndex(){
        return "login";
    }

    @RequestMapping(value = "/interface")
    public String showInterface(){
        return "interface";
    }

    @RequestMapping(value = "/register")
    public String showRegister(){
        return "register";
    }

    @RequestMapping(value = "/profile")
    public String showProfile(){
        return "profile";
    }

    @RequestMapping(value = "/book")
    public String showBook(){
        return "book";
    }

    @RequestMapping(value = "/borrow")
    public String showBorrow(){
        return "borrow";
    }

    @RequestMapping(value = "/record")
    public String showRecord(){
        return "record";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.setAttribute("id","");
        return "login";
    }

    @RequestMapping(value = "/showWho")
    @ResponseBody
    public String showWho(HttpSession session){
        String who = (String)session.getAttribute("who");
        if(who.equals("reader")){
            return "reader";
        }
        else if(who.equals("admin")){
            return "admin";
        }
        else{
            return "show who error";
        }
    }

    @RequestMapping(value = "/info")
    public String showInfo(HttpSession session, @RequestParam String book_No){
        session.setAttribute("book_No",book_No);
        return "info";
    }

    @RequestMapping(value = "/add")
    public String addBook(){
        return "add";
    }

    @RequestMapping(value = "/showReaderRecord")
    public String showReaderRecord(){
        return "readerRecord";
    }

    @RequestMapping(value = "/fine")
    public String showFine(){
        return "fine";
    }

}
