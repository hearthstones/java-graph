package com.graph.mq.controller;

import com.graph.mq.consts.DestinationConst;
import com.graph.mq.template.TemplateProducer;
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
        producer.syncSend(DestinationConst.TEMPLATE_TOPIC, msg);
    }

    @PostMapping("/asyncSend")
    public void asyncSend(String msg) {
        producer.asyncSend(DestinationConst.TEMPLATE_TOPIC, msg);
    }

    @PostMapping("/sendOneWay")
    public void sendOneWay(String msg) {
        producer.sendOneWay(DestinationConst.TEMPLATE_TOPIC, msg);
    }


}
