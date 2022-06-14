package com.qingfeng.service.impl;

import com.qingfeng.bean.MemberReadStateEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.MemberReadStateDao;
import com.qingfeng.service.MemberReadStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author 清风学Java
 */
@Service
public class MemberReadStateServiceImpl implements MemberReadStateService {

    @Autowired
    private MemberReadStateDao memberReadStateDao;

    /**
     * 查询会员阅读状态
     * @param bookId
     * @param memberId
     * @return
     */
    @Override
    public ResultVO queryMemberReadState(Integer bookId, Integer memberId) {
        MemberReadStateEntity memberReadStateEntity = memberReadStateDao.queryMemberReadState(bookId, memberId);
        return new ResultVO(ResStatus.OK, "success", memberReadStateEntity);
    }

    /**
     * 添加会员图书阅读状态
     * @param bookId
     * @param memberId
     * @param readState
     * @return
     */
    @Override
    public ResultVO addMemberReadState(int bookId, int memberId, Integer readState) {
        MemberReadStateEntity memberReadStateEntity = new MemberReadStateEntity();
        memberReadStateEntity.setBookId((long) bookId);
        memberReadStateEntity.setMemberId((long) memberId);
        memberReadStateEntity.setReadState(readState);
        //添加之前要先查询是否已经存在
        MemberReadStateEntity memberReadStateEntity1 = memberReadStateDao.queryMemberReadState(bookId, memberId);
        if (memberReadStateEntity1 == null){
            memberReadStateEntity.setCreateTime(new Date());
            int result = memberReadStateDao.addMemberReadState(memberReadStateEntity);
            if (result > 0) {
                return new ResultVO(ResStatus.OK, "操作成功！",null);
            } else {
                return new ResultVO(ResStatus.NO, "error",null);
            }
        }else{
            return new ResultVO(ResStatus.OK, "已经添加过啦",null);
        }
    }
}