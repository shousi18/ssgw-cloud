package com.shousi.ssgw.cloud.feign;

import com.shousi.ssgw.cloud.entity.User;
import com.shousi.ssgw.cloud.feign.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Order 微服务 -> 远程调用(feign接口) -> User 微服务
 */
@FeignClient(value = "ssgw-cloud-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * feign接口方法声明:与远程调用微服务中的Controller的方法声明保持一致
     * @param userId
     * @return
     */
    @GetMapping("/api/user/findUserByUserId/{userId}")
    public User findUserByUserId(@PathVariable(value = "userId") Long userId);
}
