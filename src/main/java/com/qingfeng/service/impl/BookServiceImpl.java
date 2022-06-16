package com.qingfeng.service.impl;

import com.qingfeng.bean.BookEntity;
import com.qingfeng.common.ResStatus;
import com.qingfeng.common.ResultVO;
import com.qingfeng.dao.BookDao;
import com.qingfeng.service.BookService;
import com.qingfeng.utils.PageHelper;
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
     * 分页查询图书列表
     * @param pageNum
     * @param limit
     * @return
     */
    @Override
    public ResultVO queryBookList(Integer pageNum, Integer limit) {
        int start = (pageNum - 1) * limit;
        List<BookEntity> bookEntityList = bookDao.queryBookList(start, limit);
        // 查询总条数
        int total = bookDao.queryBookTotal();
        //计算总页数
        int totalPage = total % limit == 0 ? total / limit : total / limit + 1;
        //封装数据
        PageHelper<BookEntity> pageHelper = new PageHelper<>(total, totalPage, bookEntityList);
        return new ResultVO(ResStatus.OK,"success",pageHelper);
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

    /**
     * 删除图书信息
     * @param id
     * @return
     */
    @Override
    public ResultVO delete(Integer id) {
        int result = bookDao.delete(id);
        if (result > 0) {
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"error",null);
        }
    }

    @Override
    public ResultVO addBook(BookEntity bookEntity) {
        int result = bookDao.addBook(bookEntity);
        if (result > 0) {
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"error",null);
        }
    }
}