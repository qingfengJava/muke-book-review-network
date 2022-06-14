package com.qingfeng.controller;

import com.qingfeng.bean.MemberEntity;
import com.qingfeng.common.ResultVO;
import com.qingfeng.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会员控制层
 *
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:01
 */
@RestController
@RequestMapping("shop/member")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 用户注册
     */
    @PostMapping("/reg")
    public ResultVO userReg(@RequestBody MemberEntity member) {
        //调用业务层用户注册的方法
        return memberService.memberReg(member);
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ResultVO userLogin(@RequestBody MemberEntity member) {
        //调用业务层用户登录的方法
        return memberService.memberLogin(member);
    }
}
