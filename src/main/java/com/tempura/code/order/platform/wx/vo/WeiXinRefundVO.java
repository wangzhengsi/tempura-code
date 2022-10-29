package com.tempura.code.order.platform.wx.vo;

import lombok.Data;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class WeiXinRefundVO {

    private List<String> outerSkuCodes;

    private String orderId;
}
