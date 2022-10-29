package com.tempura.code.order.service.oms;

import com.tempura.code.order.dto.TradeDTO;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
public interface IOrderCommonService {

    /**
     * 订单落库
     * @param tradeDTO 订单信息
     * @return 是否成功落库
     */
    boolean insertOrder(TradeDTO tradeDTO);

    /**
     * 根据子单号获取对应的内部订单号集合
     * @param subOrderIds 子单号集合
     * @return 内部订单号集合
     */
    List<String> getTradeIdsBySubOrderIds(List<String> subOrderIds);

    /**
     * 获取合并、拆分后的订单
     * @param tradeIds 内部订单号集合
     * @return 合并、拆分后的订单
     */
    List<String> getOperateByTradeIds(List<String> tradeIds);
}
