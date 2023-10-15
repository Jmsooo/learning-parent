package com.jmye.rocketmq.boot.producer;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/15 21:55
 * @Version 1.0
 */
@Component
public class BootProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送消息
     *
     * @param topic   主题
     * @param message 消息
     */
    public void sendMessage(String topic, String message) {
        // 将 message 转换成 Message 对象并发送
        rocketMQTemplate.convertAndSend(topic, message);
    }

    public void sendMessageInTransaction(String topic, String message) throws Exception {
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            // 注意该message为org.springframework.messaging.Message
            Message<String> sendMessage = MessageBuilder.withPayload(message).build();
            // topic和tag整合在⼀起，以":"隔开
            String destination = topic + ":" + tags[i % tags.length];
            // 第⼀个destination为消息要发到的⽬的地，第⼆个destination为 消协携带的业务数据
            TransactionSendResult sendResult = rocketMQTemplate.sendMessageInTransaction(destination, sendMessage, destination);
            System.out.println(sendResult);
            Thread.sleep(10);
        }
    }
}
