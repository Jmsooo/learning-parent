package com.jmye.rocketmq.boot.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param topic   主题
     * @param message 消息
     */
    public void sendMessage(String topic, String message) {
        // 将 message 转换成 Message 对象并发送
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
