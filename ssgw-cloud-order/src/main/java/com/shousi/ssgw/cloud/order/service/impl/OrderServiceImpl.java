package com.shousi.ssgw.cloud.order.service.impl;

import com.shousi.ssgw.cloud.entity.Order;
import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.feign.UserFeignClient;
import com.shousi.ssgw.cloud.order.mapper.OrderMapper;
import com.shousi.ssgw.cloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 查询订单（携带用户信息）
     *
     * @param orderId
     * @return
     */
    @Override
    public Order findOrderByOrderId(Long orderId) {
        Order order = orderMapper.findOrderByOrderId(orderId);
//        User user = restTemplate.getForObject(
//                "http://localhost:10100/api/user/findUserByUserId/" + order.getUserId(),
//                User.class);

//        User user = restTemplate.getForObject(
//                "http://ssgw-cloud-user/api/user/findUserByUserId/" + order.getUserId(),
//                User.class);

        // 动态代理实现远程调用
        User user = userFeignClient.findUserByUserId(order.getUserId());

        order.setUser(user);
        return order;
    }
}