package com.graph.mq.stream.channel;

import com.graph.mq.consts.ChannelConst;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 普通消息MQ配置
 *
 * @author luchao
 * @since 2022/5/16
 */
public interface NormalProcessor {

    String OUTPUT = ChannelConst.NORMAL_OUTPUT;

    String INPUT = ChannelConst.NORMAL_INPUT;

    /**
     * 普通消息 - 发送
     *
     * @return OutputChannel
     */
    @Output(OUTPUT)
    MessageChannel output();

    /**
     * 普通消息 - 订阅
     *
     * @return InputChannel
     */
    @Input(INPUT)
    SubscribableChannel input();

}
