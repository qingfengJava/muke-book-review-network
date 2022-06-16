package com.qingfeng.service.impl;

import com.qingfeng.bean.CategoryEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.CategoryDao;
import com.qingfeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public ResultVO queryList() {
        List<CategoryEntity> categoryList = categoryDao.queryList();
        return new ResultVO(ResStatus.OK,"success",categoryList);
    }
}