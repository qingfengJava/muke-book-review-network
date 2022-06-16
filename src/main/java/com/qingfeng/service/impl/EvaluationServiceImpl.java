package com.qingfeng.service.impl;

import com.qingfeng.bean.EvaluationEntity;
import com.qingfeng.bean.EvaluationEntityVo;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.EvaluationDao;
import com.qingfeng.service.EvaluationService;
import com.qingfeng.utils.PageHelper;
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

    /**
     * 分页查询所有评价列表
     * @param pageNum
     * @param limit
     * @param bookId
     * @return
     */
    @Override
    public ResultVO findAllEvaluation(Integer pageNum, Integer limit, Integer bookId) {
        int start = (pageNum - 1) * limit;
        List<EvaluationEntityVo> evaluationList = evaluationDao.findAllEvaluation(start,limit,bookId);
        // 查询总条数
        int count = evaluationDao.findAllEvaluationCount(bookId);
        // 计算总页数
        int totalPage = count % limit == 0 ? count / limit : count / limit + 1;
        //封装数据
        PageHelper<EvaluationEntityVo> evaluationEntityVoPageHelper = new PageHelper<>(count, totalPage, evaluationList);
        return new ResultVO(ResStatus.OK, "success", evaluationEntityVoPageHelper);
    }

    @Override
    public ResultVO updateEvaluation(EvaluationEntity evaluationEntity) {
        evaluationEntity.setCreateTime(new Date());
        int result = evaluationDao.updateEvaluation(evaluationEntity);
        if (result > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "error",null);
        }
    }

    @Override
    public ResultVO enableEvaluation(Integer evaluationId) {
        int result = evaluationDao.enableEvaluation(evaluationId);
        if (result > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "error",null);
        }
    }

    @Override
    public ResultVO findEvaluationById(Integer evaluationId) {
        EvaluationEntity evaluationEntity = evaluationDao.findEvaluationById(evaluationId);
        return new ResultVO(ResStatus.OK, "success", evaluationEntity);
    }

    @Override
    public ResultVO updateShortComment(EvaluationEntity evaluationEntity) {
        int result = evaluationDao.updateShortComment(evaluationEntity);
        if (result > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "error",null);
        }
    }
}