package com.qingfeng.service;

import com.qingfeng.bean.UserEntity;
import com.qingfeng.common.ResultVO;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:20:58
 */
public interface UserService{

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResultVO userReg(UserEntity user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    ResultVO userLogin(UserEntity user);
}

