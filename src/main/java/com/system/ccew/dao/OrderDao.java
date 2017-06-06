package com.system.ccew.dao;

import com.system.ccew.entity.OrderEntity;
import com.system.ccew.entity.OrderState;
import org.hibernate.Session;
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

    @SuppressWarnings("unchecked")
    public List<OrderEntity> findByUser(int userId){
        //        String hql = " from UsersEntity e where e.usersName like 'xiao%' and e.usersPassword like 'psd%'";

        Session session = sessionFactory.getCurrentSession();
     return    session.createQuery("from com.system.ccew.entity.OrderEntity  where userId ="+userId).list();
//        return findBy("userId",userId+"");
    }

//    public List<OrderEntity> findByBidid(String bidid){
//        return findBy("bidid",bidid);
//    }

//    public List<OrderEntity> findByIdCard(String idCard){
//        return findBy("idCard",idCard);
//    }

//    public List<OrderEntity> findByState(OrderState state){
//        return findBy("state",state.ordinal()+"");
//    }


}
