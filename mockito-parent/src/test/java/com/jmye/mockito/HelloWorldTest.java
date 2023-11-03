package com.jmye.mockito;

import com.jmye.mockito.dao.DemoDao;
import com.jmye.mockito.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 21:45
 * @Version 1.0
 */
public class HelloWorldTest {
    @Test
    public void helloWorldTest() {
        // mock DemoDao instance
        DemoDao mockDemoDao = Mockito.mock(DemoDao.class);

        // 使用 mockito 对 getDemoStatus 方法打桩
        Mockito.when(mockDemoDao.getDemoStatus()).thenReturn(1);

        // 调用 mock 对象的 getDemoStatus 方法，结果永远是 1
        Assert.assertEquals(1, mockDemoDao.getDemoStatus());

        // mock DemoService
        DemoService mockDemoService = new DemoService(mockDemoDao);
        Assert.assertEquals(1, mockDemoService.getDemoStatus());
    }

}
