package com.system.ccew.controller;

import com.system.ccew.dao.OrderDao;
import com.system.ccew.entity.OrderEntity;
import com.system.ccew.entity.OrderState;
import com.system.ccew.entity.UserEntity;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.lang.Integer;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Controller
public class OrderController {
    @Autowired
    OrderDao orderDao;

    @RequestMapping("/order")
    public String orders() {
        return "order";
    }

    @RequestMapping("/orderlist")
    @ResponseBody
    public List<OrderEntity> findOrderList() {
        return orderDao.findAll();
    }


    @RequestMapping("/deleteorder")
    @ResponseBody
    public boolean deleteOrder(@RequestParam(name = "orderId") String orderid) {
        OrderEntity order =orderDao.findById(orderid);
       return orderDao.delete(order);
    }


    @RequestMapping("/updateorder")
    @ResponseBody
    public boolean updateOrder(@RequestParam(name = "newState") String newState,
                               @RequestParam(name = "orderId") String orderId
    ){
        OrderEntity orderEntity=orderDao.findById(orderId);
        orderEntity.setState(OrderState.valueOf(newState));
        orderDao.update( orderEntity);
        return true;
    }

}