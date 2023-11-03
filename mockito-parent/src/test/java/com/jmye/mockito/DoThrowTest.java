package com.jmye.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 22:06
 * @Version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class DoThrowTest {

    static class ExampleService {

        public void hello() {
            System.out.println("Hello");
        }

    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test() {

        // 这种写法可以达到效果
        doThrow(new RuntimeException("异常")).when(exampleService).hello();

        try {
            exampleService.hello();
            Assert.fail();
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }

    }
}
