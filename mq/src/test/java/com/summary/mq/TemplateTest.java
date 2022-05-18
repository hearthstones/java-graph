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
        producer.sendOrderly(TopicConst.TEMPLATE_TOPIC, IdUtil.fastUUID());
    }

    @Test
    public void sendDisOrderly() {
        String topic = TopicConst.TEMPLATE_TOPIC;
        for (int i = 0; i < 20; i++) {
            producer.syncSend(topic, "无序消息测试 - " + i);
        }
    }

}
