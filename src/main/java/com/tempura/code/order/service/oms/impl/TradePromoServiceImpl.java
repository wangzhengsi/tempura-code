package com.tempura.code.order.service.oms.impl;

import com.tempura.code.order.service.oms.ITradePromoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
public class TradePromoServiceImpl implements ITradePromoService {

    @Override
    public List<String> queryAppendTrade(List<String> tradeIds) {
        List<String> appendIds = new ArrayList<>();
        appendIds.add("333333");
        return appendIds;
    }
}
