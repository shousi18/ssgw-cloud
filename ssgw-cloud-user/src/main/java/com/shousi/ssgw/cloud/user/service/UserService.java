package com.shousi.ssgw.cloud.user.service;

import com.shousi.ssgw.cloud.entity.User;

public interface UserService {

    // 根据用户的id查询用户详情
    User findUserByUserId(Long userId);

    void queryUsers();
}