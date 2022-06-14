package com.qingfeng.dao;

import com.qingfeng.bean.EvaluationEntity;
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
}
