package com.jmye.mockito;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 23:49
 * @Version 1.0
 */

import com.jmye.mockito.service.ExampleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)     // 这是必须的
@PrepareForTest(ExampleService.class)  // 声明要处理 ExampleService
public class PowerMockDemo {
    @Test
    public void test() {

        PowerMockito.mockStatic(ExampleService.class);  // 这也是必须的

        when(ExampleService.add(1, 2)).thenReturn(100);

        Assert.assertEquals(100, ExampleService.add(1, 2));
        Assert.assertEquals(0, ExampleService.add(2, 2));

    }
}
