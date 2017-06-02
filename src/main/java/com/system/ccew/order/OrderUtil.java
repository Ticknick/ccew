package com.system.ccew.order;

import com.system.ccew.dao.OrderDao;
import com.system.ccew.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author finderlo
 * @date 16/05/2017
 */
@Component
public class OrderUtil {


    @Autowired
    OrderDao orderDao;

//    public boolean canCreate(UserEntity user) {
//        if (getCreditValue(user) < Constant.USER_CAN_CREATE_ORDER_CREDIT_LIMIT) {
//            return false;
//        }
//        int runingOrderCount = orderDao.findByReplacementId(user.getUid()).size();
//        if (runingOrderCount > Constant.USER_CREATE_ORDER_MAX_COUNT) {
//            return false;
//        }
//
//        int complaintCount = orderDao.findByIdAndState(user.getUid(), OrderEntity.OrderState.COMPLAINING).size();
//        if (complaintCount != 0) {
//            return false;
//        }
//
//        return true;
//    }



}
