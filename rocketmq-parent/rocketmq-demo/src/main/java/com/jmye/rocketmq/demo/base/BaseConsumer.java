package com.jmye.rocketmq.demo.base;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/13 21:18
 * @Version 1.0
 */
public class BaseConsumer {
    public static void main(String[] args) throws MQClientException {
        // 1.创建消费者对象
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-producer-group-a");
        // 2.指定 nameserver 地址
        consumer.setNamesrvAddr("172.16.46.151:9876");
        // 3.订阅主题: topic 和 过滤消费用的tag表达式
        consumer.subscribe("mytopica","*");
        // 4.创建一个监听器, 当 broker 把消息推过来时调用
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt msg : msgs) {
                    System.out.println("收到的消息 = " + new String(msg.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        // 5.启动消费者
        consumer.start();
        System.out.println("消费者已启动...");
    }
}
