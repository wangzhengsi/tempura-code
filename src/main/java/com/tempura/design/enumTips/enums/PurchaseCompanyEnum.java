package com.tempura.design.enumTips.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author wzs
 * @date 2022/10/16
 */
@AllArgsConstructor
@Getter
public enum PurchaseCompanyEnum {

    BRAND1("B10000001", Arrays.asList("公司A")),
    BRAND2("B10000002",Arrays.asList("公司B","公司C","公司D")),
    BRAND3("B10000003",Arrays.asList("公司B","公司C")),
    ;

    private String brandId;
    private List<String> companyCodes;

    public static List<String> getCompanyCodes(String brandId){
        for (PurchaseCompanyEnum purchaseCompanyEnum : PurchaseCompanyEnum.values()) {
            if(Objects.equals(purchaseCompanyEnum.getBrandId(),brandId)){
                return purchaseCompanyEnum.getCompanyCodes();
            }
        }
        return Collections.emptyList();
    }

}
