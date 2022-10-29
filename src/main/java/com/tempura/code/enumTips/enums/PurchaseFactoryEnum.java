package com.tempura.code.enumTips.enums;


import com.tempura.code.enumTips.service.FinishedPurchaseService;
import com.tempura.code.enumTips.service.IPurchaseService;
import com.tempura.code.enumTips.service.MaterialPurchaseService;
import com.tempura.code.utils.SpringContextUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author wzs
 * @date 2022/10/16
 */
@AllArgsConstructor
@Getter
public enum PurchaseFactoryEnum {
    FINISHED("finished","成品采购单", FinishedPurchaseService.class),
    MATERIAL("material","物料采购单", MaterialPurchaseService.class),
    ;

    private String type;
    private String desc;
    private Class<?> service;

    public static IPurchaseService getService(String type){
        for (PurchaseFactoryEnum purchaseFactoryEnum : PurchaseFactoryEnum.values()) {
            if(Objects.equals(purchaseFactoryEnum.getType(),type)){
                return (IPurchaseService) SpringContextUtils.getBean(purchaseFactoryEnum.getService());
            }
        }
        throw new RuntimeException();
    }
}
