package com.tempura.design.enumTips.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wzs
 * @date 2022/10/16
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    STATUS_Y("Y","开启"),
    STATUS_N("N","关闭"),
    ;

    private String code;
    private String desc;
}
