package com.qingfeng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类编号
	 */
	private Long categoryId;
	/**
	 * 图书分类
	 */
	private String categoryName;

}
