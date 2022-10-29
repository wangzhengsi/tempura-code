package com.tempura.code.order.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class Shop implements Serializable {

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺id
     */
    private String appKey;

    /**
     * 店铺秘钥
     */
    private String appSecret;

    /**
     * 店铺token
     */
    private String token;
}
