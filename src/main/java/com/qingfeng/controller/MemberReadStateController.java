package com.qingfeng.controller;

import com.qingfeng.common.ResultVO;
import com.qingfeng.service.MemberReadStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:00
 */
@RestController
@RequestMapping("shop/memberreadstate")
@CrossOrigin
public class MemberReadStateController {

    @Autowired
    private MemberReadStateService memberReadStateService;

    /**
     * 查询会员阅读状态
     */
    @GetMapping("/query/{bookId}/{memberId}")
    public ResultVO queryMemberReadState(@PathVariable("bookId") Integer bookId,
                                         @PathVariable("memberId") Integer memberId) {
        return memberReadStateService.queryMemberReadState(bookId, memberId);
    }

    /**
     * 添加会员图书阅读状态
     */
    @PostMapping("/add/{bookId}/{memberId}/{readState}")
    public ResultVO addMemberReadState(@PathVariable("bookId") Integer bookId,
                                       @PathVariable("memberId") Integer memberId,
                                       @PathVariable("readState") Integer readState) {
        return memberReadStateService.addMemberReadState(bookId, memberId,readState);
    }

}
