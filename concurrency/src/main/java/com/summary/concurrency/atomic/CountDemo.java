package com.summary.concurrency.atomic;

/**
 * 计数demo
 *
 * @author luchao
 * @since 2022/8/4
 */
public class CountDemo {

    public static void main(String[] args) {
        // 三种计数方式
        CountUnsafe countUnsafe = new CountUnsafe();
        CountByLock countByLock = new CountByLock();
        CountByAtomic countByAtomic = new CountByAtomic();

        // 多线程计数
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    countUnsafe.add();
                    countByLock.add();
                    countByAtomic.add();
                }
            }).start();
        }

        // 等待
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出
        System.out.println("线程不安全：" + countUnsafe.get());
        System.out.println("lock计数 ：" + countByLock.get());
        System.out.println("原子类计数：" + countByAtomic.get());
    }

}
