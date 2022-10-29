package com.tempura.code.order.factory;

import com.tempura.code.order.platform.AbstractPlatformService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author wzs
 * @since 2022/10/18
 */
@Component
public class PlatformStrategyFactory {

    @Resource
    private List<AbstractPlatformService> abstractPlatformServices;

    private final HashMap<String,AbstractPlatformService> instanceMap = new HashMap<>(16);

    @PostConstruct
    public void registered(){
        abstractPlatformServices.forEach(service -> instanceMap.put(service.getStrategyCode(),service));
    }

    public AbstractPlatformService getService(String code){
        AbstractPlatformService service = instanceMap.get(code);
        Assert.notNull(service,"服务不存在，平台编码:"+code);
        return service;
    }
}
