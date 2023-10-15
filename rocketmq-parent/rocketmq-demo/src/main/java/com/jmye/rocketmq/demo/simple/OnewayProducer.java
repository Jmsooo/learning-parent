package com.jmye.rocketmq.demo.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/13 22:07
 * @Version 1.0
 */
public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup2");
        producer.setNamesrvAddr("172.16.46.151:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("TopicTest2", "TagC", ("hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        Thread.sleep(5000);
        producer.shutdown();
    }
}
