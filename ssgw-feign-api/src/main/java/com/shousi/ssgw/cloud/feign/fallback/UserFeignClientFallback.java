package com.shousi.ssgw.cloud.feign.fallback;

import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.feign.UserFeignClient;

/**
 * 降级处理类：
 *  1. 实现Feign接口
 *  2. 重写Feign接口方法（代替远程调用返回兜底结果）
 */
public class UserFeignClientFallback implements UserFeignClient {

    /**
     * 降级方法，返回兜底数据
     * @param userId
     * @return
     */
    @Override
    public User findUserByUserId(Long userId) {
        System.out.println("feign降级方法执行了");
        return new User();
    }
}
