package com.qingfeng.service;

import com.qingfeng.bean.BookEntity;
import com.qingfeng.common.ResultVO;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:03
 */
public interface BookService{

    /**
     * 查询所有图书列表
     * @return
     */
    ResultVO queryList();

    /**
     * 分页查询图书列表
     * @param pageNum
     * @param limit
     * @return
     */
    ResultVO queryBookList(Integer pageNum, Integer limit);

    /**
     * 按条件进行查询
     * @param categoryId
     * @param styleId
     * @return
     */
    ResultVO queryListByCondition(Integer categoryId, Integer styleId);

    /**
     * 根据图书Id查询图书详情
     * @param id
     * @return
     */
    ResultVO queryDetail(Integer id);

    /**
     * 删除图书信息
     * @param id
     * @return
     */
    ResultVO delete(Integer id);

    /**
     * 添加图书信息
     * @param bookEntity
     * @return
     */
    ResultVO addBook(BookEntity bookEntity);
}

