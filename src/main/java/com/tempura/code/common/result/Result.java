package com.tempura.code.common.result;

import lombok.Data;

/**
 * @author wzs
 * @date 2022/10/18
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T model;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 总条数
     */
    private Long totalRecord;
}
