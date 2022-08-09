package com.summary.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类计数
 *
 * @author luchao
 * @since 2022/8/4
 */
public class CountByAtomic {

    private final AtomicInteger num = new AtomicInteger(0);

    public void add() {
        num.getAndIncrement();
    }

    public int get() {
        return num.get();
    }

}
