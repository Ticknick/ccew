package com.system.ccew.common.util;


import com.system.ccew.common.ErrorCode;
import com.system.ccew.common.SedException;
import com.system.ccew.constant.HttpStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author finderlo
 * @date 16/05/2017
 */
public class Assert {

    public static void isNull(Object o, String message) {
        isNull(o, HttpStatus.WRONG_AUGUMENT, message);
    }

    public static void isNull(Object o, int status, String message) {
        if (o != null) {
            throw new SedException(status, message);
        }
    }

    public static void isTrue(boolean b, String message) {
        if (!b) {
            throw new SedException(HttpStatus.WRONG_AUGUMENT, message);
        }
    }

    public static void isStringExist(String s){
        if (s ==null || "".equals(s.trim())){
            throw new IllegalArgumentException();
        }
    }


    public static void isTrue(boolean b, int status, String message) {
        if (!b) {
            throw new SedException(status, message);
        }
    }

    public static void notNull(Object o, int status, String message) {
        if (o == null) {
            throw new SedException(status, message);
        }
    }



    public static void checkNotEqual(@Null Object type, @NotNull Object target, ErrorCode errorCode) {
        if (!target.equals(type)) {
            throw new SedException(errorCode);
        }
    }


}
