package com.jmye.rocketmq.boot;

import com.jmye.rocketmq.boot.producer.BootProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    @Autowired
    private BootProducer producer;

    @Test
    void testSendMessage() {
        String topic = "boot-topic";
        String message = "hello rocket mq spring boot message";
        producer.sendMessage(topic, message);
        System.out.println("消息发送成功!");
    }

    @Test
    void testSendTransactionMessage() throws Exception {
        String topic = "boot-topic";
        String message = "hello transaction spring boot rocketmq";
        producer.sendMessageInTransaction(topic, message);
    }

}
