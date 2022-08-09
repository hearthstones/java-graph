package com.summary.concurrency.threadpool.hutool;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * hutool创建线程池 Demo
 *
 * @author luchao
 * @since 2022/8/9
 */
public class HuToolThreadPoolDemo {

    public static void main(String[] args) {
        // hutool创建线程池
        ThreadPoolExecutor executor = ExecutorBuilder.create()
                .setCorePoolSize(5)
                .setMaxPoolSize(20)
                .setKeepAliveTime(100L, TimeUnit.SECONDS)
                .useArrayBlockingQueue(10)
                .setThreadFactory(ThreadFactoryBuilder.create().setNamePrefix("hutool-pool-").build())
                .setHandler(new ThreadPoolExecutor.AbortPolicy())
                .build();
        // 执行任务
        for (int i = 0; i < 100; i++) {
            final int index = i;
            executor.execute(() -> System.out.println("当前任务：" + index + "，当前线程：" + Thread.currentThread().getName()));
        }
    }

}
