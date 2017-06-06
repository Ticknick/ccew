package com.system.ccew.config.annotation;

import com.system.ccew.common.Response;
import com.system.ccew.common.util.Assert;
import com.system.ccew.constant.Constant;
import com.system.ccew.constant.HttpStatus;
import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.UserEntity;
import com.system.ccew.token.TokenManager;
import com.system.ccew.token.TokenModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author finderlo
 * @date 15/05/2017
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    com.system.ccew.common.LoggerFactory loggerFactory;

    private Logger logger ;

    public AuthorizationInterceptor(){
        logger.info("aaaa   嗷嗷啊啊啊啊啊啊啊啊啊");
        logger = loggerFactory.getLogger(com.system.ccew.common.LoggerFactory.class);
    }

    @Autowired
    private TokenManager manager;

    @Autowired
    private UserDao userDao;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle: request:" + request.getRequestURI() + "  " + request.getMethod());

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // get token from header
        String authorization = request.getParameter(Constant.AUTHORIZATION);
        TokenModel model = manager.getToken(authorization);
        //check authorization
        if (manager.checkToken(model)) {
            //验证成功后，如果含有管理员认证，则判断是否为管理员
            if (method.getAnnotation(AdminAuthorization.class) != null) {
                //todo 使用token存储身份，不然这样太耗时了
                logger.info("begin check admin authorization");
                UserEntity admin = userDao.findById(model.getUid());
                Assert.notNull(admin, HttpStatus.WRONG_AUGUMENT, "wrong admin uid");
                if (admin.getId() != 123456){
//                if (!admin.getIdentity().equals(UserEntity.UserIdentity.ADMINISTRATOR)
//                        && admin.getUid().length() > 5) {
                    logger.warn("Admin authorization fail, user id is " + model.getUid());
                    Response response1 = new Response(HttpStatus.UNAUTHORIZATON, "Admin authorization fail, user id is " + model.getUid(), null);
                    response.getWriter().append(response1.toString()).flush();
                    return false;
                }
                logger.info("admin authorization success");
            }


            logger.info("user authorization ok, user id is " + model.getUid());
            request.setAttribute(Constant.CURRENT_USER_ID, model.getUid());
            return true;
        }

        System.out.println("user authorization fail, user id is " + model);

        if (method.getAnnotation(Authorization.class) != null) {
            logger.info("user authorization fail, user token model is " + model);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().append(Response.error(HttpStatus.UNAUTHORIZATON, "unauthoriation").toString()).flush();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        logger.info("postHandle request: " + request.getRequestURI() + "  " + request.getMethod());
        logger.info("postHandle response: " + response);

    }
}
