package com.ncu.bms.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fade
 * @date 2023/03/26
 */
@Controller
@RequestMapping("/bms")
public class HtmlViewController {

    @RequestMapping(value = "/ok")
    public String testControllerWork() {
        System.out.println("Controller Work Normally!");
        return "test";
    }

}
