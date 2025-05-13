package com.shousi.ssgw.cloud.sba;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer // 启动 spring-boot-admin server
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class , args) ;
    }

}