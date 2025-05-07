package com.shousi.ssgw.cloud.user.service.impl;

import com.shousi.ssgw.cloud.user.entity.User;
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
        return userMapper.findUserByUserId(userId);
    }
}