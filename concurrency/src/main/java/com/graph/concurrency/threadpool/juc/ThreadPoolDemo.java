package com.graph.concurrency.threadpool.juc;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 手动创建线程池 Demo
 *
 * @author luchao
 * @since 2022/8/8
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        // 手动创建线程池（熟悉全部参数）
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                10,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                // hutool ThreadFactoryBuilder
                ThreadFactoryBuilder.create().setNamePrefix("手动创建线程池-").build(),
                // 默认即 AbortPolicy
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> System.out.println("当前任务：" + index + "，当前线程：" + Thread.currentThread().getName()));
        }
    }

}
