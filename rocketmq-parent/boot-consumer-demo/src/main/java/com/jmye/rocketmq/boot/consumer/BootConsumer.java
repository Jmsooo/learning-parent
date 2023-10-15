package com.jmye.rocketmq.boot.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/15 22:07
 * @Version 1.0
 */
@Component
@RocketMQMessageListener(consumerGroup = "boot-producer-group1", topic = "boot-topic")
public class BootConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("收到的消息: " + message);
    }
}
