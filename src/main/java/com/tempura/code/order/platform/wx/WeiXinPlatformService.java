package com.tempura.code.order.platform.wx;

import com.tempura.code.order.domain.Trade;
import com.tempura.code.order.domain.TradeItem;
import com.tempura.code.order.domain.TradeReceiver;
import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.enums.PlatformEnum;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.param.RefundSearchParam;
import com.tempura.code.order.platform.AbstractPlatformService;
import com.tempura.code.order.platform.wx.vo.WeiXinOrder;
import com.tempura.code.order.platform.wx.vo.WeiXinProductInfo;
import com.tempura.code.order.platform.wx.vo.WeiXinRefundVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
public class WeiXinPlatformService extends AbstractPlatformService {

    @Resource
    private WeiXinUtils weiXinUtils;

    @Override
    public String getStrategyCode() {
        return PlatformEnum.WX.getPlatform();
    }

    @Override
    public List<TradeDTO> orderPull(OrderPullParam param) {
        // 模拟http请求
        List<WeiXinOrder> weiXinOrders = weiXinUtils.orderPull();

        // 组装好的公共订单数据集合
        List<TradeDTO> pullResult = new ArrayList<>();

        // 组装数据
        weiXinOrders.forEach(weiXinOrder -> {
            // 订单主体信息
            Trade trade = new Trade().setOrderId(weiXinOrder.getOrderId());
            // 收件人信息
            TradeReceiver tradeReceiver = new TradeReceiver();
            // 商品明细
            List<WeiXinProductInfo> productInfos = weiXinOrder.getWeiXinOrderDetail().getWeiXinProductInfos();
            // 微信平台订单号
            String orderId = weiXinOrder.getOrderId();
            // 组装订单明细
            List<TradeItem> tradeItems = productInfos.stream()
                    .map(productInfo -> new TradeItem()
                            .setNum(productInfo.getSkuCnt())
                            .setSkuCode(productInfo.getSkuCode())
                            .setOuterSkuCode(productInfo.getSkuId())
                            .setSubOrderId(generateSubOrderId(orderId,productInfo.getSkuId())))
                    .collect(Collectors.toList());
            // 订单数据体
            TradeDTO tradeDTO = new TradeDTO()
                    .setTradeItems(tradeItems)
                    .setTrade(trade)
                    .setTradeReceiver(tradeReceiver);
            pullResult.add(tradeDTO);
        });

        return pullResult;
    }

    @Override
    public TradeRefundDTO refundSearch(RefundSearchParam param) {
        // 模拟http请求
        List<WeiXinRefundVO> weiXinRefunds = weiXinUtils.refundSearch();

        // 组装子单号
        List<String> subOrderIds = new ArrayList<>();
        weiXinRefunds.forEach(refund -> {
            // 微信平台订单号
            String orderId = refund.getOrderId();
            refund.getOuterSkuCodes().forEach(outerSkuCode -> {
                String subOrderId = generateSubOrderId(orderId, outerSkuCode);
                subOrderIds.add(subOrderId);
            });
        });

        // 根据子订单号集合获取所有关联的主单号
        List<String> tradeIds = super.getTradesBySubOrderId(subOrderIds);

        // 组装退款信息
        return new TradeRefundDTO().setTradeIds(tradeIds).setSubOrderIds(subOrderIds);
    }


    private String generateSubOrderId(String orderId,String outerSkuCode){
        return orderId + "-" + outerSkuCode;
    }
}
