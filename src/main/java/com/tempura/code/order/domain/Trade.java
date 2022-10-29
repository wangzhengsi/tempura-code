package com.tempura.code.order.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wzs
 * @date 2022/10/18
 */
@Data
@Accessors(chain = true)
public class Trade implements Serializable {

    /**
     * 内部订单号
     */
    private String tradeId;

    /**
     * 平台订单号
     */
    private String orderId;

    /**
     * 买家id
     */
    private String receiverId;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 订单创建时间
     */
    private Integer createTime;

    /**
     * 订单支付时间
     */
    private Integer payTime;

    /**
     * 订单修改时间
     */
    private Integer updateTime;

    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 拦截状态
     */
    private String lockStatus;

}
