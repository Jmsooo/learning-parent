package com.jmye.mockito.dao;

import java.util.Random;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 21:35
 * @Version 1.0
 */
public class DemoDao {
    public int getDemoStatus() {
        return new Random().nextInt();
    }
}
