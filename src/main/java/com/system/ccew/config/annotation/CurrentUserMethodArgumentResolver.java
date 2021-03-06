package com.system.ccew.config.annotation;

import com.system.ccew.constant.Constant;
import com.system.ccew.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @author finderlo
 * @date 15/05/2017
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        logger.info("resolveArgument():begin to get user to parameter because have @" + CurrentUser.class.getName() + " annotation");

        //取出存入的用户ID
        String currentUserId = (String) webRequest.getAttribute(Constant.CURRENT_USER_ID, RequestAttributes.SCOPE_REQUEST);

        if (currentUserId != null) {
            return userDao.findById(currentUserId);
        }
        logger.info("resolveArgument(): user not found" + ", uid: " + currentUserId);
        return new MissingServletRequestPartException(Constant.CURRENT_USER_ID);
    }
}
