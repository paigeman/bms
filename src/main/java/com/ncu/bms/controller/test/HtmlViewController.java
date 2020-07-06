package com.ncu.bms.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/bms")
public class HtmlViewController {

    @RequestMapping(value = "/ok")
    public String testControllerWork(HttpServletResponse response) throws IOException {
        System.out.println("Controller Work Normally!");
        return "test";
    }

}
