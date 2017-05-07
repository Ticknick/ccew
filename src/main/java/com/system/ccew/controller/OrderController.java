package com.system.ccew.controller;

import com.system.ccew.dao.OrderDao;
import com.system.ccew.entity.OrderEntity;
import com.system.ccew.entity.UserEntity;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Controller
public class OrderController {
    @Autowired
    OrderDao orderDao;
    @RequestMapping("/order")
public String orders(){
        return "order";
    }
    @RequestMapping("/orderlist")
    @ResponseBody
    public List<OrderEntity> findOrderList() {
        return orderDao.findAll();
    }
}