package com.graph.mq.stream.channel;

import com.graph.mq.consts.ChannelConst;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 事务消息订阅配置
 *
 * @author luchao
 * @since 2022/5/17
 */
public interface TxSink {

    String INPUT = ChannelConst.TX_INPUT;

    /**
     * 事务消息 - 订阅
     *
     * @return InputChannel
     */
    @Input(INPUT)
    SubscribableChannel input();

}
