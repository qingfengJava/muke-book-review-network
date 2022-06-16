package com.qingfeng.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/6/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KindEditorResult {

    /**
     * 0成功 1失败
     */
    private Integer error;
    /**
     * 上传成功时路径
     */
    private String url;
    /**
     * 上传失败时信息
     */
    private String message;
}
