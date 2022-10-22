package com.tempura.design.utils;

import lombok.SneakyThrows;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author wzs
 * @since 2022/10/22
 */
public class ConcurrentStartUtil<T> {

    private static final String THREAD_NAME_PREFIX = "multiStart-exec-";

    private CountDownLatch startFlag;
    private CountDownLatch waitDone;
    private Supplier<T> supplier;
    private Consumer<Exception> errorHandler;

    private ConcurrentHashMap<String,T> resultMap;

    public static <T> Map<String,T> start(int threadCount,
                                   Supplier<T> supplier,
                                   Consumer<Exception> errorHandler){
        return new ConcurrentStartUtil<T>().doStart(threadCount,supplier,errorHandler);

    }

    public static <T> Map<String,T> start(int threadCount,
                                          Supplier<T> supplier){
        return new ConcurrentStartUtil<T>().doStart(threadCount,supplier,null);

    }

    @SneakyThrows
    public Map<String,T> doStart(int threadCount,
                                   Supplier<T> supplier,
                                   Consumer<Exception> errorHandler){
        this.startFlag = new CountDownLatch(1);
        this.waitDone = new CountDownLatch(threadCount);
        this.resultMap = new ConcurrentHashMap<>(threadCount);
        this.supplier = supplier;
        this.errorHandler = errorHandler;

        for (int i = 1; i <= threadCount; i++) {
            Thread workThread = new WorkThread<>(this);
            workThread.setName(THREAD_NAME_PREFIX + i);
            workThread.start();
        }
        startFlag.countDown();
        waitDone.await();
        return resultMap;
    }

    private static class WorkThread<T> extends Thread{

        private final ConcurrentStartUtil<T> context;

        public WorkThread(ConcurrentStartUtil<T> context) {
            this.context = context;
        }

        @Override
        @SneakyThrows
        public void run() {
            context.startFlag.await();
            try{
                context.resultMap.put(Thread.currentThread().getName(), context.supplier.get());
            }catch (Exception e){
                if(Objects.isNull(context.errorHandler)){
                    throw e;
                }
                context.errorHandler.accept(e);
            }finally {
                context.waitDone.countDown();
            }

        }
    }




}
