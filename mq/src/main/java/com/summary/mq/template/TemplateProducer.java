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
     * 普通消息 - 同步发送
     *
     * @param topic topic
     * @param msg 消息
     */
    public void syncSend(String topic, String msg) {
        rocketmqTemplate.syncSend(topic, msg);
    }

    /**
     * 普通消息 - 异步发送
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
     * 普通消息 - 单向发送
     *
     * @param topic topic
     * @param msg 消息
     */
    public void sendOneWay(String topic, String msg) {
        rocketmqTemplate.sendOneWay(topic, msg);
    }

    /**
     * 顺序消息
     * <p>
     *   1. 同步、异步、单向同理。
     *   2. 模拟订单场景，以订单ID作为Sharding Key，那么同一个订单相关的创建订单消息、订单支付消息、订单退款消息、订单物流消息都会按照发布的先后顺序来消费。
     * </p>
     *
     * @param topic topic
     * @param orderId 订单ID
     */
    public void sendOrderly(String topic, String orderId) {
        // 创建订单消息
        rocketmqTemplate.syncSendOrderly(topic, "创建，订单ID - " + orderId, orderId);
        // 订单支付消息
        rocketmqTemplate.syncSendOrderly(topic, "支付，订单ID - " + orderId, orderId);
        // 订单退款消息
        rocketmqTemplate.syncSendOrderly(topic, "退款，订单ID - " + orderId, orderId);
        // 订单物流消息
        rocketmqTemplate.syncSendOrderly(topic, "物流，订单ID - " + orderId, orderId);
    }


}
