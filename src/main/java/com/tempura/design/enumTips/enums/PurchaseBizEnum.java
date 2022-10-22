package com.tempura.design.enumTips.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author wzs
 * @date 2022/10/16
 */
@Getter
@AllArgsConstructor
public enum PurchaseBizEnum {
    STATUS0("0","采购入库","CGRK"),
    STATUS1("1","调拔入库","DBRK"),
    STATUS2("2","采购退货","CGTH"),
    STATUS3("3","退货入库","THRK"),
    ;

    private String code;
    private String desc;
    private String outerBizCode;

    public static String getCode(String outerBizCode){
        for (PurchaseBizEnum purchaseBizEnum : PurchaseBizEnum.values()) {
            if(Objects.equals(purchaseBizEnum.getOuterBizCode(),outerBizCode)){
                return purchaseBizEnum.getCode();
            }
        }
        throw new RuntimeException();
    }
}
