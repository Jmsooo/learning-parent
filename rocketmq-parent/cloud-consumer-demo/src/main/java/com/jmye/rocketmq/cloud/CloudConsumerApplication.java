package com.jmye.rocketmq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Hello world!
 */
@EnableBinding(Sink.class)
@SpringBootApplication
public class CloudConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerApplication.class, args);
    }
}
