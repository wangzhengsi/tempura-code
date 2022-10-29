package com.tempura.code.order.platform.dy.v2;

import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.platform.dy.DouYinPlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
@Slf4j
@Order(2)
public class DouYinPlatformV2Service extends DouYinPlatformService {

    @Override
    public List<TradeDTO> orderPull(OrderPullParam param) {
        log.info("抖音订单拉取 v2接口");
        return new ArrayList<>();
    }

}
