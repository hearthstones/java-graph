package com.summary.mq;

import com.summary.mq.template.TemplateProducer;
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
public class MqTest {

    @Resource
    private TemplateProducer producerSample;

    @Test
    public void sendMsgTest() {
        producerSample.syncSend("test-topic1", "first mq msg");
    }

}
