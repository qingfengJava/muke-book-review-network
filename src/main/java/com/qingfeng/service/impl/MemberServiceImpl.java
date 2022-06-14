package com.qingfeng.service.impl;

import com.qingfeng.bean.MemberEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.MemberDao;
import com.qingfeng.service.MemberService;
import com.qingfeng.utils.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 清风学Java
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    /**
     * 会员注册
     * @param memberEntity
     * @return
     */
    @Override
    public ResultVO memberReg(MemberEntity memberEntity) {
        //首先查询用户是否已经存在
        MemberEntity oldMember = memberDao.selectMemberByUsername(memberEntity.getUsername());
        if (oldMember != null) {
            return new ResultVO(ResStatus.NO,"会员信息已存在，请直接去登录！",null);
        }
        //用户名不存在，可以进行注册
        //1、生成随机盐
        String salt = SaltUtils.getSalt(4);
        //2、利用Spring框架给我们提供的工具类进行md5加密
        String newPassword = DigestUtils.md5DigestAsHex((memberEntity.getPassword()+salt).getBytes(StandardCharsets.UTF_8));
        memberEntity.setPassword(newPassword);
        memberEntity.setSalt(salt);
        memberEntity.setCreateTime(new Date());
        //向数据库中注册新用户
        int result = memberDao.insertUser(memberEntity);
        if (result > 0) {
            return new ResultVO(ResStatus.OK,"注册成功！",null);
        }
        return new ResultVO(ResStatus.NO,"注册失败！",null);
    }

    /**
     * 会员登录
     * @param memberEntity
     * @return
     */
    @Override
    public ResultVO memberLogin(MemberEntity memberEntity) {
        //根据用户名查询用户信息
        MemberEntity oldMember = memberDao.selectMemberByUsername(memberEntity.getUsername());
        if(oldMember == null){
            return new ResultVO(ResStatus.LOGIN_FAIL_USERNAME,"用户信息不存在！",null);
        }else{
            //利用Spring框架给我们提供的工具类进行md5加密
            String password = DigestUtils.md5DigestAsHex((memberEntity.getPassword()+oldMember.getSalt()).getBytes(StandardCharsets.UTF_8));
            if (password.equals(oldMember.getPassword())) {
                return new ResultVO(ResStatus.LOGIN_SUCCESS, "登录成功！", oldMember);
            }else{
                return new ResultVO(ResStatus.LOGIN_FAIL_PASSWORD, "密码错误！", null);
            }
        }
    }
}