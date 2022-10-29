package com.tempura.code.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Getter
@AllArgsConstructor
public enum TradeLockEnum {
    UNBLOCKED("N", "未拦截"),
    BLOCKED("Y", "已拦截"),
    CLOSED("C", "已关闭"),
    MERGE("M", "已被合并"),
    ;

    private String code;

    private String desc;
}
