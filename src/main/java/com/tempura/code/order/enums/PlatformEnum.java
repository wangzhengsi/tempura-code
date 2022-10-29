package com.tempura.code.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wzs
 * @date 2022/10/18
 */
@Getter
@AllArgsConstructor
public enum PlatformEnum {

    DY("DY","抖音"),
    PDD("PDD","拼多多"),
    WX("WX","微信小店"),
    ;

    private String platform;
    private String desc;
}
