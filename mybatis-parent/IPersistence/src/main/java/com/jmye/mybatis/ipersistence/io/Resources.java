package com.jmye.mybatis.ipersistence.io;

import java.io.InputStream;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:19
 * @Version 1.0
 */
public class Resources {
    /**
     * 根据配置文件的路径, 将配置文件加载成字节输入流, 存储在内存中
     */
    public static InputStream getResourceAsStream(String path) {
        return Resources.class.getClass().getResourceAsStream(path);
    }
}
