package com.graph.concurrency.lock;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.log.StaticLog;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁demo
 *
 * @author luchao
 * @since 2022/8/22
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                20,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                ThreadFactoryBuilder.create().setNamePrefix("lock-pool1-").build());
        // 并发抽奖20次
        Lottery lottery = new Lottery();
        for (int i = 0; i < 20; i++) {
            executor.execute(lottery::lottery);
        }
    }

}


/**
 * 抽奖类
 */
class Lottery {

    /**
     * 初始库存大小
     */
    private int prizeSku = 10;

    private final Random random = new Random();

    private final Lock lock = new ReentrantLock(true);

    /**
     * 抽奖
     *
     */
    public void lottery() {
        String currThreadName = Thread.currentThread().getName();
        // 抽奖
        boolean hasWon = random.nextInt(10) < 8;
        // 未中奖
        if (!hasWon) {
            StaticLog.info("当前线程：{}。抽奖结果：用户未中奖。实时库存：{}。", currThreadName, prizeSku);
            return;
        }
        // 中奖，处理中奖结果
        lock.lock();
        try {
            // 校验库存，库存不足则返回未中奖
            if (prizeSku <= 0) {
                StaticLog.info("当前线程：{}。抽奖结果：用户未中奖。实时库存：{}。", currThreadName, prizeSku);
                return;
            }
            // 扣减库存
            prizeSku--;
            StaticLog.info("当前线程：{}。抽奖结果：用户已中奖。实时库存：{}。", currThreadName, prizeSku);
            // 其他：保存中奖记录、发短信通知...
        } finally {
            lock.unlock();
        }
    }

}
