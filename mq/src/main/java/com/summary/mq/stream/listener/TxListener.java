package com.summary.mq.stream.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;

/**
 * 事务消息本地事务监听器
 *
 * @author luchao
 * @since 2022/5/18
 */
@RocketMQTransactionListener(txProducerGroup = "tx-group")
public class TxListener implements RocketMQLocalTransactionListener {

    /**
     * 执行本地事务
     *
     * @param message 消息
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        return RocketMQLocalTransactionState.COMMIT;
    }

    /**
     * 回查本地事务状态
     *
     * @param message 消息
     * @return 本地事务状态
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String txId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        // todo:

        return RocketMQLocalTransactionState.COMMIT;
    }

}
