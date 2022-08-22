package com.graph.mq.stream.producer;

import com.graph.mq.stream.channel.NormalProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 普通消息 - 生产者
 *
 * @author luchao
 * @since 2022/5/16
 */
@Component
@EnableBinding(NormalProcessor.class)
public class NormalProducer {

    @Resource
    private NormalProcessor normalProcessor;

    public void send(String msg) {
        normalProcessor.output().send(MessageBuilder.withPayload(msg).build());
    }

}
