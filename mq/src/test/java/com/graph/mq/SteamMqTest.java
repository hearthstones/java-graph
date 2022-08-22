package com.graph.mq;

import com.graph.mq.stream.producer.NormalProducer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * SteamMqTest
 *
 * @author luchao
 * @since 2022/5/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SteamMqTest {

    @Resource
    private NormalProducer normalProducer;

    @Test
    public void normalSendTest() {
        normalProducer.send("普通消息测试");
    }

}
