package com.tempura.code.order.platform;


import com.tempura.code.order.mapper.MessageMapper;
import com.tempura.code.order.mapper.TaskMapper;
import com.tempura.code.order.param.BatchSensitiveParam;
import com.tempura.code.order.service.oms.IOrderCommonService;
import com.tempura.code.order.service.oms.ITradePromoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wzs
 * @since 2022/10/29
 */
public abstract class AbstractPlatformService implements IPlatformService,IPlatformEncryptService{

    @Resource
    private IOrderCommonService orderCommonService;

    @Resource
    private ITradePromoService tradePromoService;

    @Override
    public Map<String, String> batchSensitive(BatchSensitiveParam pram) {
        throw new UnsupportedOperationException("不支持批量脱敏业务");
    }


    /**
     * 根据子订单号集合获取所有关联的主单号
     * @param subOrderIds 子单号集合
     * @return 主单号
     */
    public List<String> getTradesBySubOrderId(List<String> subOrderIds) {

        // 根据子单号集合获取订单集合
        List<String> tradeIds = orderCommonService.getTradeIdsBySubOrderIds(subOrderIds);

        // 获取合并、拆分后的内部订单号
        List<String> operateIds = orderCommonService.getOperateByTradeIds(tradeIds);

        // 获取营销策略解析出的订单
        List<String> tradePromoIds = tradePromoService.queryAppendTrade(tradeIds);

        tradeIds.addAll(operateIds);
        tradeIds.addAll(tradePromoIds);

        return tradeIds;
    }


    @Resource
    private MessageMapper messageMapper;

    @Resource
    private TaskMapper taskMapper;

    // @Transactional(rollbackFor = Exception.class)
    public void insertData(String content){
        messageMapper.insert(content);
        int errorNum = 1 / 0;
        taskMapper.insert(content);
    }
}
