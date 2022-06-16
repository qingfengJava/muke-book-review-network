package com.qingfeng.controller;

import com.qingfeng.bean.EvaluationEntity;
import com.qingfeng.common.ResultVO;
import com.qingfeng.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@RestController
@RequestMapping("shop/evaluation")
@CrossOrigin
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    /**
     * 根据图书id查询评价
     */
    @GetMapping("findEvaluationByBookId/{bookId}")
    public ResultVO findByBookId(@PathVariable("bookId") Integer bookId) {
        return evaluationService.findByBookId(bookId);
    }

    /**
     * 添加图书评价
     */
    @PostMapping("addEvaluation")
    public ResultVO addEvaluation(@RequestBody EvaluationEntity evaluationEntity) {
        return evaluationService.addEvaluation(evaluationEntity);
    }

    /**
     * 评价点赞
     */
    @PostMapping("addLike/{evaluationId}")
    public ResultVO addLike(@PathVariable("evaluationId") Integer evaluationId, Integer star) {
        return evaluationService.addLike(evaluationId,star);
    }

    /**
     * 分页查询所有评价列表
     */
    @GetMapping("findAllEvaluation")
    public ResultVO findAllEvaluation(Integer pageNum, Integer limit,Integer bookId) {
        return evaluationService.findAllEvaluation(pageNum,limit,bookId);
    }

    /**
     * 修改图书评价
     */
    @PostMapping("updateEvaluation")
    public ResultVO updateEvaluation(@RequestBody EvaluationEntity evaluationEntity) {
        return evaluationService.updateEvaluation(evaluationEntity);
    }

    /**
     * 启用图书评价
     */
    @PostMapping("enableEvaluation/{evaluationId}")
    public ResultVO enableEvaluation(@PathVariable("evaluationId") Integer evaluationId) {
        return evaluationService.enableEvaluation(evaluationId);
    }

    /**
     * 根据评价Id查询评价
     */
    @GetMapping("findEvaluationById/{evaluationId}")
    public ResultVO findEvaluationById(@PathVariable("evaluationId") Integer evaluationId) {
        return evaluationService.findEvaluationById(evaluationId);
    }

    /**
     * 修改短评
     */
    @PostMapping("updateShortComment")
    public ResultVO updateShortComment(@RequestBody EvaluationEntity evaluationEntity) {
        return evaluationService.updateShortComment(evaluationEntity);
    }
}
