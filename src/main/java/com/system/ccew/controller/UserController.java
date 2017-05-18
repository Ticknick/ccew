package com.system.ccew.controller;

import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Controller

public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/UserRowEditing")
    @ResponseBody
    public boolean userRowEditing(UserEntity user) {
        userDao.update(user);
        return true;
    }

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
        } else return false;
    }
}
