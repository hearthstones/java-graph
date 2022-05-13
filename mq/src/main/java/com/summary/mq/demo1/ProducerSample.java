package com.summary.mq.demo1;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 生产者
 *
 * @author luchao
 * @since 2022/5/13
 */

@Component
public class ProducerSample {

    @Resource
    private RocketMQTemplate rocketMqTemplate;

    public void sendMsg(String topic, String msg) {
        rocketMqTemplate.syncSend(topic, msg);
    }

}
