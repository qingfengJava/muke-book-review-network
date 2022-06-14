package com.qingfeng.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EvaluationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评价编号
	 */
	private Long evaluationId;
	/**
	 * 短评内容
	 */
	private String content;
	/**
	 * 评分-5分制
	 */
	private Integer score;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	/**
	 * 会员编号
	 */
	private Long memberId;
	/**
	 * 图书编号
	 */
	private Long bookId;
	/**
	 * 点赞数量
	 */
	private Integer enjoy;
	/**
	 * 审核状态 enable-有效 disable-已禁用
	 */
	private String state;
	/**
	 * 禁用理由
	 */
	private String disableReason;
	/**
	 * 禁用时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date disableTime;

}
