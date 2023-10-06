package com.jmye.spring6.ioc.hw.core;

import com.jmye.spring6.ioc.hw.annotations.Bean;
import com.jmye.spring6.ioc.hw.annotations.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 23:56
 * @Version 1.0
 */
public class AnnotationApplicationContext implements ApplicationContext {
    // 存储Bean的容器
    private HashMap<Class, Object> beanFactory = new HashMap<>();
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

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                // 把测试类排除
                if (filePath.contains("test-classes")){
                    continue;
                }
                // 获取根路径
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                // 包扫描 @Bean
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 依赖注入 @Di
        loadDi();
    }

    private void loadDi() {
        try {
            for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
                Object object = entry.getValue();
                Field[] declaredFields = object.getClass().getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Di diAnnotation = field.getAnnotation(Di.class);
                    if (diAnnotation != null){
                        field.set(object,beanFactory.get(field.getType()));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadBean(File file) {
        try {
            // 判断当前是否是文件夹
            if (file.isDirectory()) {
                // 获取文件夹中的所有内容(文件 + 文件夹)
                File[] childrenFiles = file.listFiles();

                // 判断是否为空
                if (childrenFiles == null && childrenFiles.length == 0) {
                    return;
                }

                // 不为空, 遍历所有文件
                for (File child : childrenFiles) {
                    // 如果还是文件夹, 递归
                    if (child.isDirectory()) {
                        loadBean(child);
                    } else {
                        // 文件, 获取包路径+类名称部分-字符串截取
                        String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                        // 判断是否是 .class 文件
                        if (pathWithClass.endsWith(".class")) {
                            // 把 / 替换成 .
                            // 把 .class 去掉
                            // 把第一个字符 . 去掉
                            String allName = pathWithClass.replaceAll("/", ".").replace(".class", "").substring(1);

                            // 判断类上是否有 @Bean 注解, 如果有, 进行实例化
                            Class<?> clazz = Class.forName(allName);
                            // 判断不是接口
                            if (!clazz.isInterface()) {
                                // 判断类上是否有 @Bean 注解
                                Bean beanAnnotation = clazz.getAnnotation(Bean.class);
                                if (beanAnnotation != null) {
                                    // 类上 @Bean 注解存在, 进行实例化
                                    Object instance = clazz.getConstructor().newInstance();
                                    // 对象实例化后, 放入 map 集合 beanFactory 中
                                    // 判断当前类是否有接口, 让接口 class 作为 map 的 key
                                    if (clazz.getInterfaces().length > 0) {
                                        beanFactory.put(clazz.getInterfaces()[0], instance);
                                    } else {
                                        beanFactory.put(clazz, instance);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
