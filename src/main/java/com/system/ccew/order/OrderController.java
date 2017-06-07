package com.system.ccew.order;

import com.system.ccew.common.Response;
import com.system.ccew.common.util.Assert;
import com.system.ccew.config.annotation.Authorization;
import com.system.ccew.config.annotation.CurrentUser;
import com.system.ccew.config.annotation.EnumParam;
import com.system.ccew.dao.OrderDao;
import com.system.ccew.dao.UserDao;
import com.system.ccew.entity.OrderEntity;
import com.system.ccew.entity.OrderState;
import com.system.ccew.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static com.system.ccew.constant.HttpStatus.WRONG_AUGUMENT;


/**
 * @author finderlo
 * @date 15/05/2017
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderUtil orderUtil;


//    @GetMapping
//    @Authorization
//    public Response findCanAccept(
//            @CurrentUser UserEntity user
//    ){
//        List<OrderEntity> orders = new ArrayList<>();
//        for (UserEntity entity : users) {
//            List<OrderEntity> ordersall = orderDao.findByRecipientId(entity.getUid());
//            for (OrderEntity orderEntity : ordersall) {
//                if (orderEntity.getState().equals(OrderEntity.OrderState.WAIT_ACCEPT)){
//                    orders.add(orderEntity);
//                }
//            }
//        }
//        return Response.ok(orders);
//    }

    /**
     * 返回订单列表
     *
     * @author Ticknick Hou
     * @date 15/05/2017
     */
    @GetMapping("/token")
    @Authorization
    public Response find(
            @CurrentUser UserEntity user) {

        Set<OrderEntity> orders = new HashSet<>();
        orders.addAll(orderDao.findByUser(user.getId()));
        return Response.ok(orders);
    }

    @Autowired
    UserDao userDao;

    /**
     * 创建一个订单:
     * <p>
     * s timestamp in format <code>yyyy-[m]m-[d]d hh:mm:ss[.f...]</code>.
     *
     * @author Ticknick Hou
     */
    @PostMapping
    @Authorization
    @Transactional(rollbackFor = Exception.class)
    public Response newOne(
            @CurrentUser UserEntity user,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String id_card,
            @RequestParam String bidid,
            @RequestParam String bidid_psd) {

        logger.info("newOne():" + user);

        if (user != null) {
            user.setName(name);
            user.setPhone(phone);
            user.setId_card(id_card);
            userDao.update(user);
        }

        OrderEntity order = new OrderEntity();
        order.setUserId(user.getId());
        order.setBidid(bidid);
        order.setBidid_psd(bidid_psd);
        order.setIdcard(id_card);
        order.setState(OrderState.WAIT);

        order.setCreateTime(new Timestamp(System.currentTimeMillis()));

        orderDao.save(order);
        return Response.ok(order);
    }


    @GetMapping("/{order_id}")
    @Authorization
    @Transactional(rollbackFor = Exception.class)
    public Response findOrderState(
            @PathVariable String order_id) {
        return Response.ok(orderDao.findById(order_id));
    }


    @PutMapping("/{order_id}")
    @Authorization
    @Transactional(rollbackFor = Exception.class)
    public Response modifyOrderState(
            @CurrentUser UserEntity user,
            @PathVariable String order_id,
            @EnumParam OrderState state) {
        OrderEntity order = orderDao.findById(order_id);
        Assert.notNull(order, WRONG_AUGUMENT, "wrong order id, can't find the order");
        order.setState(state);
        orderDao.update(order);
        return Response.ok(order);
    }


    @GetMapping("/{order_id}/process")
    @Authorization
    public Response get_process(
            @CurrentUser UserEntity user,
            @PathVariable String order_id) {
        OrderEntity order = orderDao.findById(order_id);
        Assert.notNull(order, WRONG_AUGUMENT, "the wrong order id");
        return Response.ok(order.getState());
    }


    @PutMapping("/{order_id}/process")
    @Authorization
    @Transactional(rollbackFor = Exception.class)
    public Response modify(
            @CurrentUser UserEntity user,
            @PathVariable String order_id,
            @EnumParam OrderState state,
            @RequestParam(required = false) String grade) {
        logger.info("/orders/" + order_id + "/process  PUT  state: " + state + ", user_id: " + user.getId());

        OrderEntity order = orderDao.findById(order_id);
        Assert.notNull(order, 400, "wrong order id");

//        if (!order.getState().equals(OrderState.WAIT)) {
//            Assert.isTrue(user.getUid().equals(order.getRecipientId())
//                            || user.getUid().equals(order.getReplacementId()),
//                    "user only can modify your participate order ");
//        }
        return Response.error();
    }


}
