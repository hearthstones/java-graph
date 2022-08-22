package com.graph.mq.template.tag;

import com.graph.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 计算交易成功率（支付成功量/下单数量）
 *
 * @author luchao
 * @since 2022/5/19
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "statistics-group",
        topic = DestinationConst.TOPIC_TRADE,
        // "order||pay"
        selectorExpression = DestinationConst.TAG_ORDER + "||" + DestinationConst.TAG_PAY,
        selectorType = SelectorType.TAG)
public class StatisticsConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("交易成功率，接收下单、支付成功消息：{}", msg);
        // 计算交易成功率（支付成功量/下单数量）...

    }

}
