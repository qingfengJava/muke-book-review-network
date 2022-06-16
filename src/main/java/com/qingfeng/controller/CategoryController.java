package com.qingfeng.controller;

import com.qingfeng.common.ResultVO;
import com.qingfeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@RestController
@RequestMapping("shop/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有图书别类
     */
    @GetMapping("/list")
    public ResultVO list() {
        return categoryService.queryList();
    }
}
