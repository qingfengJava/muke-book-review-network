package com.qingfeng.dao;

import com.qingfeng.bean.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:01
 */
@Mapper
public interface MemberDao {

    /**
     * 根据会员名查询会员信息
     * @param username
     * @return
     */
    MemberEntity selectMemberByUsername(String username);

    /**
     * 注册会员信息
     * @param memberEntity
     * @return
     */
    int insertUser(MemberEntity memberEntity);

    /**
     * 根据id查询会员信息
     * @param memberId
     * @return
     */
    MemberEntity selectMemberById(Integer memberId);
}
