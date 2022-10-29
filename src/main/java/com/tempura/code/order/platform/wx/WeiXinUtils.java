package com.tempura.code.order.platform.wx;

import com.tempura.code.order.platform.wx.vo.WeiXinOrder;
import com.tempura.code.order.platform.wx.vo.WeiXinOrderDetail;
import com.tempura.code.order.platform.wx.vo.WeiXinProductInfo;
import com.tempura.code.order.platform.wx.vo.WeiXinRefundVO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Component
public class WeiXinUtils {
    public List<WeiXinRefundVO> refundSearch(){
        WeiXinRefundVO weiXinRefundVO = new WeiXinRefundVO();
        weiXinRefundVO.setOuterSkuCodes(Arrays.asList("101222","1005555"));
        weiXinRefundVO.setOrderId("10566666878");
        return Arrays.asList(weiXinRefundVO);
    }

    public List<WeiXinOrder> orderPull(){
        WeiXinOrder weiXinOrder = new WeiXinOrder();
        weiXinOrder.setOrderId("789324445555555");
        WeiXinOrderDetail weiXinOrderDetail = new WeiXinOrderDetail();
        WeiXinProductInfo weiXinProductInfo = new WeiXinProductInfo();
        weiXinProductInfo.setSkuCnt(1);
        weiXinProductInfo.setTitle("洗发水");
        weiXinProductInfo.setSkuId("189999");
        weiXinProductInfo.setSkuCode("SKU70026");
        weiXinOrderDetail.setWeiXinProductInfos(Arrays.asList(weiXinProductInfo));
        weiXinOrder.setWeiXinOrderDetail(weiXinOrderDetail);

        return Arrays.asList(weiXinOrder);
    }
}
