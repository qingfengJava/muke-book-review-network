package com.qingfeng.controller;

import com.qingfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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

}
