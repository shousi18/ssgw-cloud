package com.shousi.ssgw.cloud.user.mapper;

import com.shousi.ssgw.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据用户的id查询用户详情
     *
     * @param userId
     * @return
     */
    User findUserByUserId(Long userId);
}