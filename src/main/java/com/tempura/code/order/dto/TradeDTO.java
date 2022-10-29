package com.tempura.code.order.dto;

import com.tempura.code.order.domain.Trade;
import com.tempura.code.order.domain.TradeItem;
import com.tempura.code.order.domain.TradeReceiver;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
@Accessors(chain = true)
public class TradeDTO implements Serializable {

    /**
     * 订单
     */
    private Trade trade;

    /**
     * 订单明细
     */
    private List<TradeItem> tradeItems;

    /**
     * 收件人
     */
    private TradeReceiver tradeReceiver;
}
