package com.summary.mq;

import cn.hutool.core.util.IdUtil;
import com.summary.mq.consts.DestinationConst;
import com.summary.mq.template.TemplateProducer;
import com.summary.mq.template.tag.TagProducer;
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
    private RocketMQTemplate rocketmqTemplate;
    @Resource
    private TemplateProducer templateProducer;
    @Resource
    private TagProducer tagProducer;

    @Test
    public void syncSendTest() {
        templateProducer.syncSend(DestinationConst.TEMPLATE_TOPIC, "消息发送测试 - 同步");
    }

    @Test
    public void asyncSendTest() {
        templateProducer.asyncSend(DestinationConst.TEMPLATE_TOPIC, "消息发送测试 - 异步");
    }

    @Test
    public void sendOneWayTest() {
        templateProducer.sendOneWay(DestinationConst.TEMPLATE_TOPIC, "消息发送测试 - 单向");
    }

    @Test
    public void sendOrderlyTest() {
        String topic = DestinationConst.TEMPLATE_TOPIC;
        String orderId = IdUtil.fastUUID();
//        producer.sendOrderly(topic, orderId);
        for (int i = 0; i < 20; i++) {
            rocketmqTemplate.syncSendOrderly(topic, "有序消息 - " + i, orderId);
        }
    }

    @Test
    public void sendDisOrderlyTest() {
        String topic = DestinationConst.TEMPLATE_TOPIC;
        for (int i = 0; i < 20; i++) {
            templateProducer.syncSend(topic, "无序消息 - " + i);
        }
    }

    @Test
    public void sendDelayTest() {
        int delayLevel = 5;
        templateProducer.sendDelay(DestinationConst.TEMPLATE_TOPIC, "延时消息，延时级别 - " + delayLevel, delayLevel);
    }

    @Test
    public void tagTest() {
        tagProducer.trade();
    }

}
