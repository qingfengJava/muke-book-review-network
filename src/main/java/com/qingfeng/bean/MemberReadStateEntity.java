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
 * @date 2022-05-21 11:21:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberReadStateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 会员阅读状态
	 */
	private Long rsId;
	/**
	 * 图书编号
	 */
	private Long bookId;
	/**
	 * 会员编号
	 */
	private Long memberId;
	/**
	 * 阅读状态 1-想看 2-看过
	 */
	private Integer readState;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

}
