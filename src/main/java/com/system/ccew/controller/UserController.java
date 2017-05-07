package com.system.ccew.controller;

import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Controller

public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/userlist")
    @ResponseBody
    public List<UserEntity> findUserList() {
        return userDao.findAll();
    }

    @RequestMapping("/userdelete")
    @ResponseBody
    public boolean userDelete(@RequestParam(name = "userId") String userid) {
//      userDao.delete();
        UserEntity a = userDao.findById(userid);
        if (a != null) {
            userDao.delete(a);
            return true;
        }else return false;
    }
}
