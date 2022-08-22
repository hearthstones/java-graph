package com.graph.mq.template.tag;

import cn.hutool.core.util.IdUtil;
import com.graph.mq.consts.DestinationConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Topic - Tag 最佳实践
 *
 * @author luchao
 * @since 2022/5/19
 */
@Slf4j
@Component
public class TagProducer {

    @Resource
    private RocketMQTemplate rocketmqTemplate;

    /**
     * 模拟下单、支付、发货流程，含伪代码
     */
    public void trade() {
        String orderId = IdUtil.fastSimpleUUID();
        // 1.创建订单...

        // 创建订单成功消息
        // 场景：延时级别16(30m)，30分钟后查单，若未支付则关闭订单。测试用5(1m)。
        rocketmqTemplate.syncSend(DestinationConst.TOPIC_TRADE + ":" + DestinationConst.TAG_ORDER,
                MessageBuilder.withPayload("订单" + orderId + "创建成功").build(),
                2000, 5
        );

        // 2.支付...

        // 支付成功消息
        // 场景：支付成功后发送短信、确认收货地址等
        rocketmqTemplate.syncSend(DestinationConst.TOPIC_TRADE + ":" + DestinationConst.TAG_PAY,
                MessageBuilder.withPayload("订单" + orderId + "支付成功").build()
        );

        // 3.自动发货...

        // 发货成功消息
        // 场景：发货成功后发送短信、处理业务等
        rocketmqTemplate.syncSend(DestinationConst.TOPIC_TRADE + ":" + DestinationConst.TAG_LOGISTICS,
                MessageBuilder.withPayload("订单" + orderId + "已发货").build()
        );

    }

}
