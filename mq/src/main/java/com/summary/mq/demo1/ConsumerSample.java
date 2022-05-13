package com.summary.mq.demo1;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * ConsumerSample
 *
 * @author luchao
 * @since 2022/5/13
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "test-topic1", consumerGroup = "consumer-test-topic1")
public class ConsumerSample implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("接收消息：{}", msg);
    }

}
