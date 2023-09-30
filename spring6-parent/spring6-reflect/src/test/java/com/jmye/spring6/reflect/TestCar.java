package com.jmye.spring6.reflect;

import com.jmye.spring6.reflect.domain.Car;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 21:13
 * @Version 1.0
 */
public class TestCar {

    /**
     * 获取Class对象的多种方式
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        // 1. 类名.class
        Class clazz1 = Car.class;

        // 2. 对象.getClass()
        Class clazz2 = new Car().getClass();

        // 3. Class.forName("全路径)
        Class clazz3 = Class.forName("com.jmye.spring6.reflect.domain.Car");

        Car car = (Car) clazz3.getConstructor().newInstance();
        System.out.println("car = " + car);
    }

    /**
     * 获取构造方法
     */
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;

        // 获取所有构造方法
        // getConstructors(): 获取所有public的构造方法
        // getDeclaredConstructors(): 获取所有的构造方法(public + private)
        // Constructor[] constructors = clazz.getConstructors();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("方法名称: " + constructor.getName() + ", 参数个数: " + constructor.getParameterCount());
        }

        // 获取指定参数构造创建对象(public)
        // Constructor constructor = clazz.getConstructors(String.class, int.class, String.class);
        // Car car1 = (Car) constructor.newInstance("夏利", 10, "红色");
        // System.out.println(car1);

        // 获取指定参数构造创建对象(private)
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        constructor.setAccessible(true);
        Car car = (Car) constructor.newInstance("捷达", 15, "白色");
        System.out.println(car);
    }

    /**
     * 获取属性
     */
    @Test
    public void test03() throws Exception{
        Class clazz = Car.class;
        
        Car car = (Car) clazz.getDeclaredConstructor().newInstance();
        // 获取所有 public 属性
        // Field[] fields = clazz.getFields();
        // 获取所有属性(public+private)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name")){
                // 设置允许访问
                field.setAccessible(true);
                field.set(car,"奔驰");
                System.out.println("car = " + car);
            }
            System.out.println("field.getName() = " + field.getName());
        }
    }

    /**
     * 获取方法
     */
    @Test
    public void test04() throws Exception{
        Car car = new Car("奔驰",10,"黑色");
        Class clazz = car.getClass();

        // 获取 public 方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // 执行 toString 方法
            if (method.getName().equals("toString")){
                String invoke = (String) method.invoke(car);
                System.out.println("invoke = " + invoke);
            }
        }

        // 获取 private 方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method method : methodsAll) {
            // 执行 run 方法
            if (method.getName().equals("run")){
                method.setAccessible(true);
                method.invoke(car);
            }
        }
    }

}
