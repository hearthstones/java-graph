package com.summary.mq.template.tag;

import com.summary.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 支付成功消费者
 *
 * @author luchao
 * @since 2022/5/19
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "pay-success-group",
        topic = DestinationConst.TOPIC_TRADE,
        selectorExpression = DestinationConst.TAG_PAY,
        selectorType = SelectorType.TAG)
public class PaySuccessConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("接收支付成功消息：{}", msg);
        // 支付成功，处理业务逻辑...

    }

}
