package com.qingfeng.dao;

import com.qingfeng.bean.EvaluationEntity;
import com.qingfeng.bean.EvaluationEntityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@Mapper
public interface EvaluationDao {

    /**
     * 根据图书id查询评价
     * @param bookId
     * @return
     */
    List<EvaluationEntity> findByBookId(Integer bookId);

    /**
     * 添加图书评价
     * @param evaluationEntity
     * @return
     */
    int addEvaluation(EvaluationEntity evaluationEntity);

    /**
     * 评价点赞
     * @param star
     * @param evaluationId
     * @return
     */
    int updateStar(@Param("evaluationId") Integer evaluationId,
                   @Param("star") Integer star);

    /**
     * 分页查询所有评价列表
     * @param start
     * @param limit
     * @param bookId
     * @return
     */
    List<EvaluationEntityVo> findAllEvaluation(@Param("start") int start,
                                               @Param("limit") Integer limit,
                                               @Param("bookId") Integer bookId);

    /**
     * 查询总数
     * @param bookId
     * @return
     */
    int findAllEvaluationCount(Integer bookId);

    /**
     * 删除图书评价
     * @param evaluationEntity
     * @return
     */
    int updateEvaluation(EvaluationEntity evaluationEntity);

    /**
     * 启用图书评价
     * @param evaluationId
     * @return
     */
    int enableEvaluation(Integer evaluationId);

    /**
     * 根据评价id查询评价
     * @param evaluationId
     * @return
     */
    EvaluationEntity findEvaluationById(Integer evaluationId);

    /**
     * 修改短评
     * @param evaluationEntity
     * @return
     */
    int updateShortComment(EvaluationEntity evaluationEntity);
}
