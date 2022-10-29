package com.tempura.code.order.param;

import com.tempura.code.order.domain.Shop;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class BatchSensitiveParam implements Serializable {

    /**
     * 密文集合
     */
    private List<String> cipherTexts;

    /**
     * 店铺信息
     */
    private Shop shop;

    private String platform;

}
