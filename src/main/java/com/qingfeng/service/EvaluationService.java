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

    /**
     * 分页查询所有评价列表
     * @param pageNum
     * @param limit
     * @param bookId
     * @return
     */
    ResultVO findAllEvaluation(Integer pageNum, Integer limit, Integer bookId);

    /**
     * 修改图书评价
     * @param evaluationEntity
     * @return
     */
    ResultVO updateEvaluation(EvaluationEntity evaluationEntity);

    /**
     * 启用图书评价
     * @param evaluationId
     * @return
     */
    ResultVO enableEvaluation(Integer evaluationId);

    /**
     * 根据评价Id查询评价
     * @param evaluationId
     * @return
     */
    ResultVO findEvaluationById(Integer evaluationId);

    /**
     * 修改短评
     * @param evaluationEntity
     * @return
     */
    ResultVO updateShortComment(EvaluationEntity evaluationEntity);
}

