package com.jmye.rocketmq.cloud;

import com.jmye.rocketmq.cloud.producer.CloudProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    @Autowired
    private CloudProducer producer;

    @Test
    void testSendMessage() throws IOException {
        producer.sendMessage("hello spring cloud stream");
    }

}
