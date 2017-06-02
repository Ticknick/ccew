//package com.system.ccew.order.task;
//
//
//import com.system.ccew.dao.OrderDao;
//
///**
// * 任务，判断订单状态是否是已接单。
// * 是，设为取消状态，发布订单取消事件，记录信用值
// * 否，
// *
// * @author finderlo
// * @date 21/04/2017
// */
//public class OrdersAcceptOverTimeTask extends Task {
//
//    private String orderId;
//
//    private OrderDao dao;
//
////    private EventManager manager;
//
//    public OrdersAcceptOverTimeTask(String orderId, OrderDao orderDao, EventManager manager) {
//        this.manager = manager;
//        this.orderId = orderId;
//        this.dao = orderDao;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        OrderEntity order = dao.findById(orderId);
//        if (order.getState().equals(OrderEntity.OrderState.ACCEPTED)) {
//            synchronized (order) {
//                if (order.getState().equals(OrderEntity.OrderState.ACCEPTED)) {
//                    order.setState(OrderEntity.OrderState.CANCELED);
//                    dao.update(order);
//                    //发布订单取消事件
//                    manager.publish(Event.OrderReplacementCancelEvent,
//                            new OrderEventContext(order));
//                }
//            }
//        }
//        order = null;
//        dao = null;
//    }
//
//
//}
