package com.graph.concurrency.threadpool.juc;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * SingleScheduledThreadPoolDemo
 *
 * @author luchao
 * @since 2022/8/8
 */
public class SingleScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        System.out.println("任务添加时间：" + LocalDateTime.now());
        executor.execute(() -> System.out.println("execute方式，执行时间：" + LocalDateTime.now()));
        executor.schedule(() -> System.out.println("schedule方式，执行时间：" + LocalDateTime.now()),
                5,
                TimeUnit.SECONDS
        );
    }

}
