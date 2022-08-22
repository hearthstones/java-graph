package com.graph.concurrency.threadpool.hutool;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;

/**
 * Hutool ThreadUtil工具类 Demo
 *
 * @author luchao
 * @since 2022/8/9
 */
public class HuToolThreadUtilDemo {

    public static void main(String[] args) {
        // hutool ThreadUtil 全局线程池（GlobalThreadPool）
        for (int i = 0; i < 10; i++) {
            final int index = i;
            ThreadUtil.execute(() -> System.out.println("当前任务：" + index + "，当前线程：" + Thread.currentThread().getName()));
        }
        // hutool ThreadUtil 新建线程池
        ExecutorService executor = ThreadUtil.newExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> System.out.println("当前任务：" + index + "，当前线程：" + Thread.currentThread().getName()));
        }
    }

}
