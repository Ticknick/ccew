package com.system.ccew.token;

import com.system.ccew.common.Response;
import com.system.ccew.config.annotation.Authorization;
import com.system.ccew.config.annotation.CurrentUser;
import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.system.ccew.constant.HttpStatus.WRONG_AUGUMENT;


/**
 * @author finderlo
 * @date 15/05/2017
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 登陆，缺少必选参数时，返回400HTTP状态码Status
     *
     * @author Ticknick Hou
     * @date 15/05/2017
     */
    @PostMapping
    public Response login(
            @RequestParam(defaultValue = "") String uid,
            @RequestParam(defaultValue = "") String phone,
            @RequestParam String password,
            @RequestParam(defaultValue = "0") int type) {
        if (uid.equals("") && phone.equals("")) {
            return Response.error(WRONG_AUGUMENT, "uid or phone parameter not exist");
        }

        UserEntity user;
        TokenModel tokenModel;

        if (!uid.equals("")) {
            user = userDao.findById(uid);
        } else {
            user = userDao.findByPhone(phone);
        }

        if (user == null ||
                !user.getPassword().equals(password)) {
            return Response.error();
        }

        tokenModel = tokenManager.createToken(user.getId());
        return Response.ok(tokenModel);

    }

    @DeleteMapping
    @Authorization
    public Response logout(@CurrentUser UserEntity user) {
        tokenManager.deleteToken(user.getId());
        return Response.ok();
    }


}
