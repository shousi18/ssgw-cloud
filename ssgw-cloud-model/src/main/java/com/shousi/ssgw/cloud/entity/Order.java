package com.shousi.ssgw.cloud.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Long id;
    private Long userId;
    private String name;
    private BigDecimal price;
    private Integer num;

    private User user;
}