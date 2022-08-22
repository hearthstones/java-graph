package com.graph.concurrency.atomic;

/**
 * 线程不安全计数
 *
 * @author luchao
 * @since 2022/8/4
 */
public class CountUnsafe {

    private int num;

    public void add() {
        num++;
    }

    public int get() {
        return num;
    }

}
