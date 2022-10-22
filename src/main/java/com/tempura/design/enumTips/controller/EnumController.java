package com.tempura.design.enumTips.controller;


import com.tempura.design.enumTips.domian.PurchaseOrder;
import com.tempura.design.enumTips.enums.*;
import com.tempura.design.enumTips.param.CreateOrderParam;
import com.tempura.design.enumTips.service.IPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wzs
 * @date 2022/10/16
 */
@RestController
@RequestMapping("/enum")
@Slf4j
public class EnumController {


    /**
     * 业务编码枚举
     */
    @GetMapping("/test1")
    public void test1(){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setStatus(StatusEnum.STATUS_Y.getCode());
        purchaseOrder.setStatus("Y");
    }

    /**
     * 属性枚举
     */
    @GetMapping("/test2")
    public void test2(String outerBizCode){
        String code = PurchaseBizEnum.getCode(outerBizCode);
        log.info("{}",code);
    }

    /**
     * 业务枚举
     * 需求:统计不同品牌的商品销量
     * 1、如果是品牌B10000001     那么只查询B10000001品牌且是公司A的销量
     * 2、如果是品牌B10000002     那么只查询B10000002品牌且是公司B、C、D的销量
     * 3、如果是品牌B10000003     那么只查询B10000003品牌且是公司B、C的销量
     * 4、如果是其他品牌           查询该品牌所有商品的销量
     */
    @GetMapping("/test3")
    public void test3(String brandId){
        // 统计不同品牌的销量
        List<String> companyCodes = PurchaseCompanyEnum.getCompanyCodes(brandId);
        search(companyCodes,brandId);
    }

    /**
     * 枚举工厂
     * 成品采购单 调用FinishedPurchaseService
     * 物料采购单 调用MaterialPurchaseService
     */
    @PostMapping("/test4")
    public void test4(@RequestBody CreateOrderParam param){
        IPurchaseService service = PurchaseFactoryEnum.getService(param.getType());
        service.createOrder(param);
    }

    /**
     * 枚举回调
     * 是否逾期打款  判断订单的payTime字段
     * 是否逾期到货  判断订单的arrivalTime字段
     * 是否逾期完结  判断订单的endingTime字段
     */
    @GetMapping("/test5")
    public void test5(@RequestParam("code") String code,@RequestParam("orderId") String orderId){
        PurchaseOrder purchaseOrder = getById(orderId);
        Boolean overdue = PurchaseOverdueEnum.isOverdue(code, purchaseOrder);
        log.info("{}",overdue);
    }

    private PurchaseOrder getById(String orderId) {
        // 2022-01-01 00:00:00
        long time = 1640966400000L;
        // 2022-12-01 00:00:00
        long time2 = 1669824000000L;
        return new PurchaseOrder()
                .setOrderId(orderId)
                .setPayTime(time2)
                .setArrivalTime(time)
                .setEndingTime(time2);
    }


    private void search(List<String> companyCode, String brandId) {
    }

}
