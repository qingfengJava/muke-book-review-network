package com.qingfeng.service.impl;

import com.qingfeng.bean.BookEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.BookDao;
import com.qingfeng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 清风学Java
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 查询所哟图书列表
     * @return
     */
    @Override
    public ResultVO queryList() {
        List<BookEntity> bookEntityList = bookDao.queryList();
        return new ResultVO(ResStatus.OK,"success",bookEntityList);
    }

    /**
     * 按条件进行查询
     * @param categoryId
     * @param styleId
     * @return
     */
    @Override
    public ResultVO queryListByCondition(Integer categoryId, Integer styleId) {
        List<BookEntity> bookEntityList = bookDao.queryListByCondition(categoryId, styleId);
        return new ResultVO(ResStatus.OK,"success",bookEntityList);
    }

    @Override
    public ResultVO queryDetail(Integer id) {
        BookEntity bookEntity = bookDao.queryDetail(id);
        return new ResultVO(ResStatus.OK,"success",bookEntity);
    }
}