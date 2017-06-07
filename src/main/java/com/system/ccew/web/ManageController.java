package com.system.ccew.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Finderlo on 2016/12/8.
 */
@Controller
public class ManageController {


    @RequestMapping("/caffeine/examine")
    public String hello() {
        return "caffeine/examine";
    }

    @RequestMapping("/caffeine/complaints")
    public String hello2() {
        return "caffeine/complaints";
    }
    @RequestMapping("/caffeine/new")
    public String hello3() {
        return "caffeine/new";
    }
    @RequestMapping("/caffeine/query")
    public String hello4() {
        return "caffeine/query";
    }
    @RequestMapping("/")
    public String hello5() {
        return "caffeine/signin";
    }

}


