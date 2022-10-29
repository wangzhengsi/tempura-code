package com.tempura.code.order.platform.pdd;

import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.enums.PlatformEnum;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.param.RefundSearchParam;
import com.tempura.code.order.platform.AbstractPlatformService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
public class PinDuoDuoPlatformService extends AbstractPlatformService {

    @Override
    public String getStrategyCode() {
        return PlatformEnum.PDD.getPlatform();
    }

    @Override
    public List<TradeDTO> orderPull(OrderPullParam param) {
        return null;
    }

    @Override
    public TradeRefundDTO refundSearch(RefundSearchParam param) {
        return null;
    }
}
