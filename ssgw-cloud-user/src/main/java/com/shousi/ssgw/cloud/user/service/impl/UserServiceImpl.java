package com.shousi.ssgw.cloud.user.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.user.mapper.UserMapper;
import com.shousi.ssgw.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserId(Long userId) {
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userMapper.findUserByUserId(userId);
    }

    @SentinelResource("users")
    public void queryUsers(){
        System.err.println("查询用户");
    }
}