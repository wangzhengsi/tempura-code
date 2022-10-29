package com.tempura.code.order.platform.wx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class WeiXinProductInfo {

    /**
     * 平台sku编码
     */
    @JSONField(name = "sku_id")
    private String skuId;

    /**
     * 商家sku编码
     */
    @JSONField(name = "sku_code")
    private String skuCode;

    /**
     * sku购买数量
     */
    @JSONField(name = "sku_cnt")
    private Integer skuCnt;

    /**
     * 商品标题
     */
    @JSONField(name = "title")
    private String title;
}
