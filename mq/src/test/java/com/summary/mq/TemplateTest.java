package com.summary.mq;

import cn.hutool.core.util.IdUtil;
import com.summary.mq.consts.TopicConst;
import com.summary.mq.template.TemplateProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * MQ测试
 *
 * @author luchao
 * @since 2022/5/13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TemplateTest {

    @Resource
    private TemplateProducer producer;
    @Resource
    private RocketMQTemplate rocketmqTemplate;

    @Test
    public void syncSendTest() {
        producer.syncSend(TopicConst.TEMPLATE_TOPIC, "消息发送测试 - 同步");
    }

    @Test
    public void asyncSendTest() {
        producer.asyncSend(TopicConst.TEMPLATE_TOPIC, "消息发送测试 - 异步");
    }

    @Test
    public void sendOneWayTest() {
        producer.sendOneWay(TopicConst.TEMPLATE_TOPIC, "消息发送测试 - 单向");
    }

    @Test
    public void sendOrderly() {
        String topic = TopicConst.TEMPLATE_TOPIC;
        String orderId = IdUtil.fastUUID();
//        producer.sendOrderly(topic, orderId);
        for (int i = 0; i < 20; i++) {
            rocketmqTemplate.syncSendOrderly(topic, "有序消息 - " + i, orderId);
        }
    }

    @Test
    public void sendDisOrderly() {
        String topic = TopicConst.TEMPLATE_TOPIC;
        for (int i = 0; i < 20; i++) {
            producer.syncSend(topic, "无序消息 - " + i);
        }
    }

    @Test
    public void sendDelay() {
        int delayLevel = 5;
        producer.sendDelay(TopicConst.TEMPLATE_TOPIC, "延时消息，延时级别 - " + delayLevel, delayLevel);
    }

}