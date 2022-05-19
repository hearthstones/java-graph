package com.summary.mq.template.tag;

import com.summary.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 短信通知消费者
 *
 * @author luchao
 * @since 2022/5/19
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "sms-group",
        topic = DestinationConst.TOPIC_TRADE,
        // "pay||logistics"
        selectorExpression = DestinationConst.TAG_PAY + "||" + DestinationConst.TAG_LOGISTICS,
        selectorType = SelectorType.TAG)
public class SmsConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        log.info("短信服务，接收支付成功、发货成功消息：{}", msg);
        // 发送短信...

    }

}
