package com.system.ccew.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Finderlo on 2016/12/8.
 */
@Controller
public class ManageController {


    @RequestMapping("/sed/examine")
    public String hello() {
        return "sed/examine";
    }

    @RequestMapping("/sed/complaints")
    public String hello2() {
        return "sed/complaints";
    }
    @RequestMapping("/message/new")
    public String hello3() {
        return "message/new";
    }
    @RequestMapping("/sed/query")
    public String hello4() {
        return "sed/query";
    }

}


