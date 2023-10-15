package com.jmye.rocketmq.cloud.producer;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/16 00:01
 * @Version 1.0
 */
@Component
public class CloudProducer {

    @Autowired
    private Source source;

    public void sendMessage(String message) throws IOException {
        // 封装消息头
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "TagA");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        // 创建消息对象
        Message<String> sendMessage = MessageBuilder.createMessage(message, messageHeaders);
        // 发送消息
        source.output().send(sendMessage);
    }

}
