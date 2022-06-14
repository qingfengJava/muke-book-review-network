package com.qingfeng.controller;

import com.qingfeng.common.ResultVO;
import com.qingfeng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:03
 */
@RestController
@RequestMapping("shop/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有图书列表，不带条件。唯一的条件的是按照热度排序
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        return bookService.queryList();
    }

    /**
     * 按条件进行查询
     */
    @GetMapping("/listByCondition/{categoryId}/{styleId}")
    public ResultVO listByCondition(@PathVariable("categoryId") Integer categoryId,
                                    @PathVariable("styleId") Integer styleId) {
        return bookService.queryListByCondition(categoryId, styleId);
    }

    /**
     * 根据图书id查询图书详情
     */
    @GetMapping("/detail/{id}")
    public ResultVO detail(@PathVariable("id") Integer id) {
        return bookService.queryDetail(id);
    }
}
