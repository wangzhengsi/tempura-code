package com.tempura.code.order.service.oms;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
public interface ITradePromoService {

    /**
     * 获取营销策略解析出的订单
     * @param tradeIds 内部订单号
     * @return 订单号集合
     */
    List<String> queryAppendTrade(List<String> tradeIds);
}
