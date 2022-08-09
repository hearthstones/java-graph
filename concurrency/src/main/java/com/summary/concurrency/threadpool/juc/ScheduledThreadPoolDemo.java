package com.summary.concurrency.threadpool.juc;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolDemo
 *
 * @author luchao
 * @since 2022/8/8
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            LocalDateTime addTime = LocalDateTime.now();
            executor.schedule(() -> System.out.println("当前线程：" + Thread.currentThread().getName()
                            + "，任务添加时间：" + addTime
                            + "，任务执行时间: " + LocalDateTime.now()
                    ),
                    3,
                    TimeUnit.SECONDS
            );
        }
    }

}
