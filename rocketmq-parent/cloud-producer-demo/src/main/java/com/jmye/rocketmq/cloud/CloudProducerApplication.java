package com.jmye.rocketmq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * Hello world!
 */
@EnableBinding(Source.class)
@SpringBootApplication
public class CloudProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudProducerApplication.class, args);
    }
}
