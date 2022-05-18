package com.summary.mq.stream.consumer;

import com.summary.mq.stream.channel.TxSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * 事务消息 - 消费者
 *
 * @author luchao
 * @since 2022/5/18
 */
@Slf4j
@Component
@EnableBinding(TxSink.class)
public class TxConsumer {

    @StreamListener(TxSink.INPUT)
    public void consume(String msg) {
        log.info("事务消息消费者，接收：{}", msg);
    }

}
