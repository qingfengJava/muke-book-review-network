package com.qingfeng.service;

import com.qingfeng.common.ResultVO;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:00
 */
public interface MemberReadStateService{

    /**
     * 查询会员阅读状态
     * @param bookId
     * @param memberId
     * @return
     */
    ResultVO queryMemberReadState(Integer bookId, Integer memberId);

    /**
     * 添加会员图书阅读状态
     * @param bookId
     * @param memberId
     * @param readState
     * @return
     */
    ResultVO addMemberReadState(int bookId, int memberId, Integer readState);
}

