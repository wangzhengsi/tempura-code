package com.tempura.code.enumTips.service;

import com.tempura.code.enumTips.param.CreateOrderParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wzs
 * @date 2022/10/16
 */
@Service
@Slf4j
public class FinishedPurchaseService implements IPurchaseService{
    @Override
    public void createOrder(CreateOrderParam param) {
        log.info("FinishedPurchaseService...");
    }
}
