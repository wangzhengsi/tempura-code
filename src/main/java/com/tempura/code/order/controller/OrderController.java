package com.tempura.code.order.controller;


import com.tempura.code.common.result.Result;
import com.tempura.code.common.result.ResultUtil;
import com.tempura.code.order.dto.TradeRefundDTO;
import com.tempura.code.order.factory.PlatformStrategyFactory;
import com.tempura.code.order.param.BatchSensitiveParam;
import com.tempura.code.order.param.OrderPullParam;
import com.tempura.code.order.param.RefundSearchParam;
import com.tempura.code.order.service.oms.IOrderCommonService;
import com.tempura.code.order.service.oms.IRefundService;
import com.tempura.code.order.platform.AbstractPlatformService;
import com.tempura.code.order.platform.dy.DouYinPlatformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author wzs
 * @date 2022/10/18
 */
@RestController
public class OrderController {

    @Resource
    private PlatformStrategyFactory platformStrategyFactory;

    @Resource
    private IOrderCommonService orderCommonService;

    @Resource
    private IRefundService refundService;

    @Resource(type = DouYinPlatformService.class)
    private AbstractPlatformService douYinPlatformService;

    /**
     * 拉取订单
     */
    @PostMapping("/orderPull")
    public Result<Void> orderPull(@RequestBody OrderPullParam param){
        platformStrategyFactory.getService(param.getPlatform()).orderPull(param)
                .forEach(tradeDTO -> orderCommonService.insertOrder(tradeDTO));
        return ResultUtil.success();
    }

    /**
     * 同步退款信息
     */
    @PostMapping("/refundSearch")
    public Result<Void> refundSearch(@RequestBody RefundSearchParam param){
        TradeRefundDTO refund = platformStrategyFactory
                .getService(param.getPlatform()).refundSearch(param);
        refundService.dealWith(refund);
        return ResultUtil.success();
    }


    /**
     * 订单脱敏
     */
    @PostMapping("/dyBatchSensitive")
    public Result<Map<String, String>> dyBatchSensitive(@RequestBody BatchSensitiveParam param){
        AbstractPlatformService service = platformStrategyFactory.getService(param.getPlatform());
        return ResultUtil.success(service.batchSensitive(param));
    }

    /**
     * 数据插入
     */
    @PostMapping("/insertData")
    public Result<Void> insertData(String content){
        douYinPlatformService.insertData(content);
        return ResultUtil.success();
    }



}
