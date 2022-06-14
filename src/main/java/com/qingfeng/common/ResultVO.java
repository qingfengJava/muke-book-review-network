package com.qingfeng.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 清风学Java
 * @date 2021/11/2
 * @apiNote
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    /**
     * 响应给前端的状态码
     */
    private Integer code;

    /**
     * 响应给前端的提示信息
     */
    private String msg;

    /**
     * 响应给前端的数据
     */
    private T data;
}
