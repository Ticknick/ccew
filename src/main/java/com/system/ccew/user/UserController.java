package com.system.ccew.user;

import com.system.ccew.common.Response;
import com.system.ccew.config.annotation.AdminAuthorization;
import com.system.ccew.config.annotation.Authorization;
import com.system.ccew.config.annotation.CurrentUser;
import com.system.ccew.constant.HttpStatus;
import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import com.system.ccew.token.TokenManager;
import com.system.ccew.token.TokenModel;
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

    @Autowired
    TokenManager tokenManager;
    @Autowired
    UserDao userDao;

    @GetMapping("/token")
    @Authorization
    public Response own(
            @CurrentUser UserEntity user,@RequestParam String token) {
        //todo there is some error, so
        TokenModel model = tokenManager.getToken(token);

        logger.info("own:"+model);
        if (!tokenManager.checkToken(model)){
            return Response.error(HttpStatus.UNAUTHORIZATON,"认证失败");
        }
        UserEntity userEntity = userDao.findById(model.getUid());
        logger.info("own:"+userEntity);
        return Response.ok(userEntity);

//        logger.info(user.toString());
//        return Response.ok(user);
    }
}
