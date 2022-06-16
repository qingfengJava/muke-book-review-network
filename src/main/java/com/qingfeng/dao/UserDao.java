package com.qingfeng.dao;

import com.qingfeng.bean.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:20:58
 */
@Repository
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserEntity selectUserByUsername(String username);

}
