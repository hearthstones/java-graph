package com.graph.concurrency.threadpool.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPoolConfig
 *
 * @author luchao
 * @since 2022/8/9
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("asyncThreadPool")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        // 核心线程数
        pool.setCorePoolSize(5);
        // 最大线程数
        pool.setMaxPoolSize(10);
        // 线程 keepAliveTime
        pool.setKeepAliveSeconds(100);
        // 工作队列大小
        pool.setQueueCapacity(2000);
        // 线程名前缀
        pool.setThreadNamePrefix("springboot-pool-");
        // 拒绝策略
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // 初始化
        pool.initialize();
        return pool;
    }

}
