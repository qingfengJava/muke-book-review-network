package com.qingfeng.dao;

import com.qingfeng.bean.BookEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:03
 */
@Repository
public interface BookDao{

    /**
     * 查询所有图书列表
     * @return
     */
    List<BookEntity> queryList();

    /**
     * 按条件进行查询
     * @param categoryId
     * @param styleId
     * @return
     */
    List<BookEntity> queryListByCondition(@Param("categoryId") Integer categoryId,
                                          @Param("styleId") Integer styleId);

    /**
     * 根据图书Id查询图书详情
     * @param id
     * @return
     */
    BookEntity queryDetail(Integer id);

    /**
     * 分页查询图书列表
     * @param start
     * @param limit
     * @return
     */
    List<BookEntity> queryBookList(@Param("start") int start,
                                   @Param("limit") Integer limit);

    /**
     * 查询图书总数
     * @return
     */
    int queryBookTotal();

    /**
     * 删除图书信息
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 添加图书信息
     * @param bookEntity
     * @return
     */
    int addBook(BookEntity bookEntity);
}
