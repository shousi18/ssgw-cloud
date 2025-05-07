package com.shousi.ssgw.cloud.order.service.impl;

import com.shousi.ssgw.cloud.order.entity.Order;
import com.shousi.ssgw.cloud.order.entity.User;
import com.shousi.ssgw.cloud.order.mapper.OrderMapper;
import com.shousi.ssgw.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询订单（携带用户信息）
     *
     * @param orderId
     * @return
     */
    @Override
    public Order findOrderByOrderId(Long orderId) {
        Order order = orderMapper.findOrderByOrderId(orderId);
        User user = restTemplate.getForObject(
                "http://localhost:10100/api/user/findUserByUserId/" + order.getUserId(),
                User.class);
        order.setUser(user);
        return order;
    }
}