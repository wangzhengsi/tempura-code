package com.tempura.code.order.platform.wx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class WeiXinOrder {

    @JSONField(name = "create_time")
    private String createTime;

    @JSONField(name = "update_time")
    private String updateTime;

    @JSONField(name = "order_id")
    private String orderId;

    @JSONField(name = "status")
    private Integer status;

    @JSONField(name = "order_detail")
    private WeiXinOrderDetail weiXinOrderDetail;
}
