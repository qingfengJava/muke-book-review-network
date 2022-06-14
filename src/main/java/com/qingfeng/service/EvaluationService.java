package com.qingfeng.service;

import com.qingfeng.bean.EvaluationEntity;
import com.qingfeng.common.ResultVO;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
public interface EvaluationService{

    /**
     * 根据图书id查询评价
     * @param bookId
     * @return
     */
    ResultVO findByBookId(Integer bookId);

    /**
     * 添加图书评价
     * @param evaluationEntity
     * @return
     */
    ResultVO addEvaluation(EvaluationEntity evaluationEntity);

    /**
     * 评价点赞
     * @param star
     * @param evaluationId
     * @return
     */
    ResultVO addLike(Integer evaluationId,Integer star);
}

