package com.graph.mq.template.tag;

import com.graph.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 查单消费者
 *
 * @author luchao
 * @since 2022/5/19
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "valid-pay-consumer",
        topic = DestinationConst.TOPIC_TRADE,
        selectorExpression = DestinationConst.TAG_ORDER,
        selectorType = SelectorType.TAG)
public class ValidPayConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("查单，接收查单消息：{}", msg);
        // 查单，若未支付则关闭订单...

    }

}
