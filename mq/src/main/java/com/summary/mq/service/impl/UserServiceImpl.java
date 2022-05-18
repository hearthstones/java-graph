package com.summary.mq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.summary.mq.domain.User;
import com.summary.mq.mapper.UserMapper;
import com.summary.mq.pojo.dto.AddUserDTO;
import com.summary.mq.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 事务消息 - 生产者
 *
 * @author luchao
 * @since 2022/5/17
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RocketMQTemplate rocketMqTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddUserDTO dto) {
        // insert
        User user = BeanUtil.copyProperties(dto, User.class);
        userMapper.insert(user);
        // 发送事务消息
        String txId = IdUtil.fastUUID();
        TransactionSendResult result = rocketMqTemplate.sendMessageInTransaction("tx-group",
                "tx-topic",
                MessageBuilder.withPayload("事务消息").setHeader(RocketMQHeaders.TRANSACTION_ID, txId).build(),
                user
        );
        log.info("发送事务消息（半消息），结果：{}", result);
    }

}
