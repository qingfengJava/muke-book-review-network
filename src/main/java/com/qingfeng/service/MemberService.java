package com.qingfeng.service;

import com.qingfeng.bean.MemberEntity;
import com.qingfeng.common.ResultVO;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:01
 */
public interface MemberService {

    /**
     * 会员注册
     * @param memberEntity
     * @return
     */
    ResultVO memberReg(MemberEntity memberEntity);

    /**
     * 会员登录
     * @param memberEntity
     * @return
     */
    ResultVO memberLogin(MemberEntity memberEntity);
}

