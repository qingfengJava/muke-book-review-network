package com.qingfeng.controller;

import com.qingfeng.bean.UserEntity;
import com.qingfeng.common.ResultVO;
import com.qingfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制层
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:20:58
 */
@RestController
@RequestMapping("shop/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public ResultVO login(@RequestBody UserEntity user) {
        return userService.userLogin(user);
    }

}
