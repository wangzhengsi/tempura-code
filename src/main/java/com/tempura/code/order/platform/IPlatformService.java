package com.tempura.code.order.platform;


import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.param.RefundSearchParam;

import java.util.List;

/**
 * @author wzs
 * @date 2022/10/18
 */
public interface IPlatformService{
    /**
     * 获得策略
     * @return 策略枚举
     */
    String getStrategyCode();


    /**
     * 订单拉取
     * @param param 请求参数
     * @return 执行结果
     */
    List<TradeDTO> orderPull(OrderPullParam param);

    /**
     * 同步退款信息
     * @param param 请求参数
     * @return 退款信息
     */
    TradeRefundDTO refundSearch(RefundSearchParam param);


}
