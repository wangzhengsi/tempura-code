package com.tempura.code.concurrent;


import com.tempura.code.concurrent.ConcurrentStartUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wzs
 * @since 2022/10/22
 */
@Slf4j
public class TestDemo {
    public static void main(String[] args) {

        Map<String,String> errorMap = new ConcurrentHashMap<>();
        Map<String, String> map = ConcurrentStartUtil.start(50, () -> {
            if(1 == 1){
                throw new RuntimeException("测试异常");
            }
            return "www";
        },(e) -> {
            errorMap.put(Thread.currentThread().getName(), e.getMessage());
        });

        Map<String, String> map2 = ConcurrentStartUtil.start(50, () -> {
            if(1 == 1){
                throw new RuntimeException("测试异常");
            }
            return "www";
        });
        System.out.println(map);
    }
}
