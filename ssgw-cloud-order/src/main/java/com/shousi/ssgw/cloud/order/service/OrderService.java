package com.shousi.ssgw.cloud.order.service;


import com.shousi.ssgw.cloud.entity.Order;

public interface OrderService {

    /**
     * 根据订单的id查询订单数据
     *
     * @param orderId
     * @return
     */
    Order findOrderByOrderId(Long orderId);
}
