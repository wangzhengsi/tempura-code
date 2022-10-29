package com.tempura.code.order.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Data
@Accessors(chain = true)
public class TradeRefundDTO {

    /**
     * 内部单号集合
     */
    private List<String> tradeIds;

    /**
     * 子单号集合
     */
    private List<String> subOrderIds;


}
