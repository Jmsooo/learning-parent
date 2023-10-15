package com.jmye.rocketmq.demo.base;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/13 08:58
 * @Version 1.0
 */
public class BaseProducer {
    public static void main(String[] args) throws Exception {
        // 1.创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("my-producer-group-a");
        // 2.指定 nameserver 地址
        producer.setNamesrvAddr("172.16.46.151:9876");
        // 3.启动生产者
        producer.start();
        // 4.创建消息
        for (int i = 0; i < 10; i++) {
            Message message = new Message("mytopica", "taga", ("hello rocketmq " + i).getBytes(StandardCharsets.UTF_8));
            // 5.发送消息
            SendResult sendResult = producer.send(message);
            System.out.println("sendResult = " + sendResult);
        }
        // 6.关闭生产者
        producer.shutdown();
    }
}
