package com.jmye.rocketmq.cloud.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/16 00:20
 * @Version 1.0
 */
@Component
public class CloudConsumer {

    @StreamListener(Sink.INPUT)
    public void onMessage(String message) {
        System.out.println("收到的消息: " + message);
    }

}
