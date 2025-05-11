package com.shousi.ssgw.cloud.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.user.properties.PatternProperties;
import com.shousi.ssgw.cloud.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@RefreshScope // 针对于@Value注解拉取配置中心的配置，实现热更新。
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${pattern.dateFormat}")
    private String pattern;

    @Autowired
    private PatternProperties patternProperties;

    @SentinelResource("hot")
    @GetMapping("/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId,
                                 @RequestHeader(value = "nihao", required = false) String header,
                                 @RequestParam(value = "name", required = false) String name) {
        if (userId == 2) {
            throw new RuntimeException("手动抛出异常，测试异常比例触发熔断规则");
        }
//        System.out.println("name = " + name);
//        System.out.println("header = " + header);
        log.info("pattern = " + pattern);
        log.info("patternProperties.getDateformat() = " + patternProperties.getDateformat());
        return userService.findUserByUserId(userId);
    }

    // 修改用户数据端点
    @GetMapping(value = "/updateUserById")
    public String updateUserById() {
        return "修改用户数据成功";
    }

    @GetMapping(value = "/save")
    public String save() {
        userService.queryUsers();
        System.out.println("保存用户");
        return "订单保存成功" ;
    }

    @GetMapping(value = "/query")
    public String query() {
        userService.queryUsers();
        System.out.println("查询用户");
        return "查询用户成功" ;
    }

}