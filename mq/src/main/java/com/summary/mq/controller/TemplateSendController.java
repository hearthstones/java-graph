package com.summary.mq.controller;

import com.summary.mq.consts.TopicConst;
import com.summary.mq.template.TemplateProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用 RocketMQTemplate 发送消息
 *
 * @author luchao
 * @since 2022/5/18
 */
@RestController
@RequestMapping("/template")
public class TemplateSendController {

    @Resource
    private TemplateProducer producer;

    @PostMapping("/syncSend")
    public void syncSend(String msg) {
        producer.syncSend(TopicConst.TEMPLATE_TOPIC, msg);
    }

    @PostMapping("/asyncSend")
    public void asyncSend(String msg) {
        producer.asyncSend(TopicConst.TEMPLATE_TOPIC, msg);
    }

    @PostMapping("/sendOneWay")
    public void sendOneWay(String msg) {
        producer.sendOneWay(TopicConst.TEMPLATE_TOPIC, msg);
    }


}
