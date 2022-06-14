package com.qingfeng.service.impl;

import com.qingfeng.bean.EvaluationEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.EvaluationDao;
import com.qingfeng.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 清风学Java
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    public ResultVO findByBookId(Integer bookId) {
        List<EvaluationEntity> evaluationList = evaluationDao.findByBookId(bookId);
        return new ResultVO(ResStatus.OK, "success", evaluationList);
    }

    @Override
    public ResultVO addEvaluation(EvaluationEntity evaluationEntity) {
        evaluationEntity.setCreateTime(new Date());
        evaluationEntity.setState("enable");
        int result = evaluationDao.addEvaluation(evaluationEntity);
        if (result > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "error",null);
        }
    }

    @Override
    public ResultVO addLike(Integer evaluationId,Integer star) {
        int result = evaluationDao.updateStar(evaluationId,star);
        if (result > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "error",null);
        }
    }
}