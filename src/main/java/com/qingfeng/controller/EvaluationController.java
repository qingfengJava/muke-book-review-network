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
}
