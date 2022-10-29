package com.tempura.code.order.platform;

import com.tempura.code.order.param.BatchSensitiveParam;

import java.util.Map;

/**
 * @author wzs
 * @date 2022/10/18
 */
public interface IPlatformEncryptService {

    /**
     * 批量脱敏接口
     * @param pram 请求参数
     * @return key:密文,value:明文
     */
    Map<String, String> batchSensitive(BatchSensitiveParam pram);
}
