package com.qingfeng.dao;

import com.qingfeng.bean.MemberReadStateEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:00
 */
@Repository
public interface MemberReadStateDao {

    /**
     * 查询会员阅读状态
     * @param bookId
     * @param memberId
     * @return
     */
    MemberReadStateEntity queryMemberReadState(@Param("bookId") Integer bookId,
                                               @Param("memberId") Integer memberId);

    /**
     * 添加会员图书阅读状态
     * @param memberReadStateEntity
     * @return
     */
    int addMemberReadState(MemberReadStateEntity memberReadStateEntity);
}
