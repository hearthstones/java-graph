package com.summary.concurrency.threadpool.spring.service.impl;

import com.summary.concurrency.threadpool.spring.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * AsyncServiceImpl
 *
 * @author luchao
 * @since 2022/8/20
 */
@Service
//@Async("asyncThreadPool")
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncThreadPool")
    public void asyncDemo() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

}
