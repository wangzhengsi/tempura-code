package com.tempura.code.order.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
@Accessors(chain = true)
public class TradeItem {

    /**
     * 子单号
     */
    private String subOrderId;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 平台侧商品编码
     */
    private String outerSkuCode;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 状态
     */
    private String itemStatus;
}
