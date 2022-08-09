package com.summary.concurrency.threadpool.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPoolDemo
 *
 * @author luchao
 * @since 2022/8/8
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> System.out.println("当前任务：" + index + "，当前线程：" + Thread.currentThread().getName()));
        }
    }

}
