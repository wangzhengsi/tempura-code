package com.tempura.design.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wzs
 * @date 2022/10/18
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS("成功", "0"),
    FAIL("失败", "1001"),
    ;

    private String message;
    private String code;
}
