package com.summary.mq.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RocketMQTemplate 生产者
 *
 * @author luchao
 * @since 2022/5/13
 */
@Slf4j
@Component
public class TemplateProducer {

    @Resource
    private RocketMQTemplate rocketmqTemplate;


    /**
     * 1.1 普通消息 - 同步发送
     *
     * @param topic topic
     * @param msg 消息
     */
    public void syncSend(String topic, String msg) {
        rocketmqTemplate.syncSend(topic, msg);
    }

    /**
     * 1.2 普通消息 - 异步发送
     *
     * @param topic topic
     * @param msg 消息
     */
    public void asyncSend(String topic, String msg) {
        rocketmqTemplate.asyncSend(topic, msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("async send message success，result: {}", sendResult);
            }
            @Override
            public void onException(Throwable throwable) {
                // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理。
            }
        });
    }

    /**
     * 1.3 普通消息 - 单向发送
     *
     * @param topic topic
     * @param msg 消息
     */
    public void sendOneWay(String topic, String msg) {
        rocketmqTemplate.sendOneWay(topic, msg);
    }

//    public void send(String topic, String msg) {
//        rocketmqTemplate.sendOrderly(topic, msg);
//    }


}
