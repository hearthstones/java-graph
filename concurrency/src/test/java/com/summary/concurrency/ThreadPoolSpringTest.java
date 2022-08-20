package com.summary.concurrency;

import com.summary.concurrency.threadpool.spring.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ThreadPoolSpringTests
 *
 * @author luchao
 * @since 2022/8/20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolSpringTest {

    @Resource
    private AsyncService asyncService;

    @Test
    public void asyncDemoTest() {
        for (int i = 0; i < 10; i++) {
            asyncService.asyncDemo();
        }
    }

}
