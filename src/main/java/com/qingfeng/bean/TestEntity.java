package com.qingfeng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:20:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String content;

}
