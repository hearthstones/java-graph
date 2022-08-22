package com.graph.mq.stream.consumer;

import com.graph.mq.stream.channel.NormalProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 普通消息 - 消费者
 *
 * @author luchao
 * @since 2022/5/16
 */
@Slf4j
@Component
@EnableBinding(NormalProcessor.class)
public class NormalConsumer {

    @StreamListener(NormalProcessor.INPUT)
    public void consume(String msg) {
        log.info("普通消息消费者，接收：{}", msg);
    }

}
