package com.system.ccew.dao;

import com.system.ccew.entity.OrderEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Repository
@Component
public class OrderDao extends AbstractDao<OrderEntity> {
//    public String findState(String state) {
//        switch (state) {
//            case "01":return "";break;
//            default: return "";break;
//        }
//    }

    public List<OrderEntity> findByUser(String user){
        return findBy("user",user);
    }

    public List<OrderEntity> findByBidid(String bidid){
        return findBy("bidid",bidid);
    }

    public List<OrderEntity> findByIdCard(String idCard){
        return findBy("idCard",idCard);
    }

    public List<OrderEntity> findByState(String state){
        return findBy("state",state);
    }


}
