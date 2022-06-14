package com.qingfeng.service.impl;

import com.qingfeng.bean.UserEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.UserDao;
import com.qingfeng.service.UserService;
import com.qingfeng.utils.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;


/**
 * @author 清风学Java
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResultVO userReg(UserEntity user) {
        //首先查询用户是否已经存在
        UserEntity oldUser = userDao.selectUserByUsername(user.getUsername());
        if (oldUser != null) {
            return new ResultVO(ResStatus.NO,"用户已存在，请直接去登录！",null);
        }
        //用户名不存在，可以进行注册
        //1、生成随机盐
        String salt = SaltUtils.getSalt(4);
        //2、利用Spring框架给我们提供的工具类进行md5加密
        String newPassword = DigestUtils.md5DigestAsHex((user.getPassword()+salt).getBytes(StandardCharsets.UTF_8));
        user.setPassword(newPassword);
        user.setSalt(salt);
        //向数据库中注册新用户
        int result = userDao.insertUser(user);
        if (result > 0) {
            return new ResultVO(ResStatus.OK,"注册成功！",null);
        }
        return new ResultVO(ResStatus.NO,"注册失败！",null);
    }

    @Override
    public ResultVO userLogin(UserEntity user) {
        //根据用户名查询用户信息
        UserEntity oldUser = userDao.selectUserByUsername(user.getUsername());
        if(oldUser == null){
            return new ResultVO(ResStatus.LOGIN_FAIL_USERNAME,"用户不存在！",null);
        }else{
            //利用Spring框架给我们提供的工具类进行md5加密
            String password = DigestUtils.md5DigestAsHex((user.getPassword()+oldUser.getSalt()).getBytes(StandardCharsets.UTF_8));
            if (password.equals(oldUser.getPassword())) {
                return new ResultVO(ResStatus.LOGIN_SUCCESS, "登录成功！", oldUser);
            }else{
                return new ResultVO(ResStatus.LOGIN_FAIL_PASSWORD, "密码错误！", null);
            }
        }
    }
}