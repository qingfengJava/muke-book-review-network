package com.qingfeng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvaluationEntityVo extends EvaluationEntity{

	/**
	 * 会员
	 */
	private MemberEntity member;
}
