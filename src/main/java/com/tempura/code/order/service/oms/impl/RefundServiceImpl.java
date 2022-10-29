package com.tempura.code.order.service.oms.impl;

import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.service.oms.IRefundService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
public class RefundServiceImpl implements IRefundService {

    @Override
    public void dealWith(TradeRefundDTO tradeRefunds) {
        // 将订单状态设置为已拦截
        List<String> tradeIds = tradeRefunds.getTradeIds();

        // 将子订单设置为退款中
        List<String> subOrderIds = tradeRefunds.getSubOrderIds();
    }
}
