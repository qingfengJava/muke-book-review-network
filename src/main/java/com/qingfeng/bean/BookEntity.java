package com.qingfeng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图书编号
	 */
	private Long bookId;
	/**
	 * 书名
	 */
	private String bookName;
	/**
	 * 子标题
	 */
	private String subTitle;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 封面图片URL
	 */
	private String cover;
	/**
	 * 图书详情
	 */
	private String description;
	/**
	 * 分类编号
	 */
	private Long categoryId;
	/**
	 * 图书评分
	 */
	private Float evaluationScore;
	/**
	 * 评价数量
	 */
	private Integer evaluationQuantity;
}
