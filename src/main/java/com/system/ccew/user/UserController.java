package com.system.ccew.user;

import com.system.ccew.common.Response;
import com.system.ccew.config.annotation.AdminAuthorization;
import com.system.ccew.config.annotation.Authorization;
import com.system.ccew.config.annotation.CurrentUser;
import com.system.ccew.constant.HttpStatus;
import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;


/**
 * @author finderlo
 * @date 15/05/2017
 */
@RestController()
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;


    @PostMapping
    public Response register(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String mail
    ) {
        logger.info("/users  POST");
        UserEntity user = new UserEntity();
        if (userDao.findByPhone(phone) != null) {
            return Response.error(HttpStatus.WRONG_AUGUMENT,"phone already exist");
        }
        user.setName(name);
        user.setPhone(phone);
        user.setPassword(password);
        user.setMail(mail);
        user.setId_card("01");
        userDao.save(user);
        logger.info(user.toString());
        return Response.ok(user);
    }

    @GetMapping
    @Authorization
    public Response find(
            @RequestParam String phone) {
        Assert.notNull(phone, "phone can not be empty");
        return Response.ok(userDao.findByPhone(phone));
    }

    @GetMapping("/{uid}")
    @AdminAuthorization
    public Response findOne(
            @PathVariable String uid) {
        return Response.ok(userDao.findById(uid));
    }


    @GetMapping("/token")
    public Response own(
            @CurrentUser UserEntity user) {
        return Response.ok(user);
    }
}
