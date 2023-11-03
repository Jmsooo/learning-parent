package com.jmye.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.mockito.Mockito.when;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 21:57
 * @Version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationTest {

    @Mock
    private Random random;

    @Test
    public void test() {
        when(random.nextInt()).thenReturn(100);
        Assert.assertEquals(100, random.nextInt());
    }
}
