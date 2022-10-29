package com.tempura.code.order.service.oms.impl;

import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.service.oms.IOrderCommonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
public class OrderCommonServiceImpl implements IOrderCommonService {

    @Override
    public boolean insertOrder(TradeDTO tradeDTO) {
        if(Objects.isNull(tradeDTO)){
            return Boolean.FALSE;
        }

        // 做各种校验

        // 匹配发货仓库

        // 解析营销活动

        // 插入订单主体信息

        // 插入订单明细

        // 插入收件人信息

        // 插入订单日志

        // 异步推送订单信息用于支撑其他业务.....
        return Boolean.TRUE;
    }

    @Override
    public List<String> getTradeIdsBySubOrderIds(List<String> subOrderIds) {
        List<String> tradeIds = new ArrayList<>();
        tradeIds.add("111111");
        return tradeIds;
    }

    @Override
    public List<String> getOperateByTradeIds(List<String> tradeIds) {
        List<String> operateIds = new ArrayList<>();
        operateIds.add("222222");
        return operateIds;
    }
}
