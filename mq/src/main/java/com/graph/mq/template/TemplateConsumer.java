package com.graph.mq.template;

import com.graph.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * TemplateConsumer
 *
 * @author luchao
 * @since 2022/5/13
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = DestinationConst.TEMPLATE_TOPIC, consumerGroup = "template-group")
public class TemplateConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("接收消息：{}", msg);
//        log.info("当前线程：{}, 接收消息：{}", Thread.currentThread().getId(), msg);
    }

}
