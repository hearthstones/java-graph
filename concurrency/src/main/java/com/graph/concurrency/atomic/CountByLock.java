package com.graph.concurrency.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁计数
 *
 * @author luchao
 * @since 2022/8/4
 */
public class CountByLock {

    private int num;

    private final Lock lock = new ReentrantLock(true);

    public void add() {
        lock.lock();
        try {
            num++;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        return num;
    }

}
