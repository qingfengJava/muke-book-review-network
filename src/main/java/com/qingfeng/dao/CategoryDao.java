package com.qingfeng.dao;

import com.qingfeng.bean.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@Repository
public interface CategoryDao{

    /**
     * 查询所有图书别类
     * @return
     */
    List<CategoryEntity> queryList();
}
