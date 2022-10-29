package com.tempura.code.order.service.oms;

import com.tempura.code.order.dto.TradeRefundDTO;

/**
 * @author wzs
 * @since 2022/10/29
 */
public interface IRefundService {

    /**
     * 处理退款信息
     * @param tradeRefunds 退款信息
     */
    void dealWith(TradeRefundDTO tradeRefunds);
}
