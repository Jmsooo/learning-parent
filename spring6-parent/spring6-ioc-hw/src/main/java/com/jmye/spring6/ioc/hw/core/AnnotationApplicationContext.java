package com.jmye.spring6.ioc.hw.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 23:56
 * @Version 1.0
 */
public class AnnotationApplicationContext implements ApplicationContext{
    // 存储Bean的容器
    private HashMap<Class,Object> beanFactory = new HashMap<>();
    // 根路径
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    /**
     * 根据包扫描, 加载Bean
     */
    public AnnotationApplicationContext(String basePackage) {
        try {
            // 把 . 替换成 \
            String packagePath = basePackage.replaceAll("\\.", "/");
            // 获取包绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);

            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                // 获取根路径
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                // 包扫描
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadBean(File fileParent) {

    }
}
