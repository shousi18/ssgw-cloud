package com.shousi.ssgw.cloud.user.controller;

import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId) {
        return userService.findUserByUserId(userId);
    }

}