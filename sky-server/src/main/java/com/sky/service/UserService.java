package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @Author: Jaymr
 * @Date: 2025/5/19 14:24
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
