package com.tempura.code.order.platform.wx.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
public class WeiXinOrderDetail {

    @JSONField(name = "product_infos")
    private List<WeiXinProductInfo> weiXinProductInfos;
}
