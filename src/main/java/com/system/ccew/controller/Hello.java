package com.system.ccew.controller;

import com.system.ccew.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author finderlo
 * @date 06/05/2017
 */
@Controller
public class Hello {

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String hello() {

//        userDao.findByIds()
//        userDao.findBy("nickname","jey")

        return "order";
    }

    @RequestMapping("/hello/as")
    public String hell1o() {
        return "hello1";
    }

    @RequestMapping("/once")
    public String once() {
        return "once";
    }

    @RequestMapping("/submit")
    public String submit(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String psd,
            Model model
    ) {
        String tip;
        //yewuluoji
        System.out.println(name);
        System.out.println(psd);
        if (name.equals("12345") && psd.equals("12345")) {
            tip = "登陆成功";
        } else {
            tip = "登录失败";
            if (!name.equals("12345")) {
                tip += "登录名错了";
            }
            if (!psd.equals("12345")) {
                tip += "密码错了";
            }
        }
        model.addAttribute("tip", tip);
        model.addAttribute("name", name);
        model.addAttribute("pwd", psd);
        return "login";
    }
}
