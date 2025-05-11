package com.shousi.ssgw.cloud.order;

import com.shousi.ssgw.cloud.feign.fallback.UserFeignClientFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.shousi.ssgw.cloud.feign")
@Import(UserFeignClientFallback.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}