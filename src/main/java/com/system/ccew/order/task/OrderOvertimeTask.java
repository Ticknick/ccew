package com.system.ccew.order.task;


import com.system.ccew.dao.OrderDao;
import com.system.ccew.entity.OrderEntity;

/**
 * 订单超时任务，用来检测订单是否为接单状态，不然设为取消状态
 * @author finderlo
 * @date 21/04/2017
 */
public class OrderOvertimeTask extends Task {

    String ordersId;

    OrderDao dao;

    public OrderOvertimeTask(String orderId, OrderDao orderDao){
        this.ordersId = orderId;
        this.dao = orderDao;
    }

    @Override
    public void run() {
        super.run();
        OrderEntity orders = dao.findById(ordersId);
//        if (orders.getState().equals(OrderEntity.OrderState.WAIT_ACCEPT)){
//            synchronized (orders){
//                if (orders.getState().equals(OrderEntity.OrderState.WAIT_ACCEPT)){
//                    orders.setState(OrderEntity.OrderState.CANCELED);
//                    dao.update(orders);
//                }
//            }
//        }
//        orders = null;
    }
}
