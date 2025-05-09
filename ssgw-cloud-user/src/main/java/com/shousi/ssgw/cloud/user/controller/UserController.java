package com.shousi.ssgw.cloud.user.controller;

import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateFormat}")
    private String pattern;

    @GetMapping("/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId,
                                 @RequestHeader(value = "nihao", required = false) String header,
                                 @RequestParam(value = "name", required = false) String name) {
//        System.out.println("name = " + name);
//        System.out.println("header = " + header);
        log.info("pattern = " + pattern);
        return userService.findUserByUserId(userId);
    }

}