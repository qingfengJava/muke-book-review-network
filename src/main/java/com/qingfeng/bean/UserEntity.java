package com.qingfeng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:20:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐值
	 */
	private String salt;

}
