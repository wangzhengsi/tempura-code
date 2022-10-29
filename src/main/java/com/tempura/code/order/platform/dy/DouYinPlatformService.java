package com.tempura.code.order.platform.dy;

import com.tempura.code.order.dto.TradeDTO;
import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.enums.PlatformEnum;
import com.tempura.code.order.param.BatchSensitiveParam;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.param.RefundSearchParam;
import com.tempura.code.order.platform.AbstractPlatformService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Service
@Slf4j
@Order(1)
public class DouYinPlatformService extends AbstractPlatformService {

    @Resource
    private DouYinUtils douYinUtils;

    @Override
    public String getStrategyCode() {
        return PlatformEnum.DY.getPlatform();
    }

    @Override
    public List<TradeDTO> orderPull(OrderPullParam param) {
        log.info("接口 v1");
        return new ArrayList<>();
    }

    @Override
    public TradeRefundDTO refundSearch(RefundSearchParam param) {
        // 模拟http请求
        List<String> subOrderIds = douYinUtils.refundSearch();

        // 根据子订单号集合获取所有关联的主单号
        List<String> tradeIds = super.getTradesBySubOrderId(subOrderIds);

        // 组装退款信息
        return new TradeRefundDTO().setTradeIds(tradeIds).setSubOrderIds(subOrderIds);
    }

    @Override
    public Map<String, String> batchSensitive(BatchSensitiveParam pram) {
        Map<String, String> result = new HashMap<>(16);
        result.put("$180$vJu6K71mjl217RfjMdx12g==$1$","176****4619");
        result.put("$13162855$uCHZ6ijidB//ZH0sTwV2Zg==$1$","朱**");
        result.put("$18468584$mD50Jz6R6JW20cgpKbivng==$1$","七**街道新**园***号**单**楼");
        return result;
    }
}
