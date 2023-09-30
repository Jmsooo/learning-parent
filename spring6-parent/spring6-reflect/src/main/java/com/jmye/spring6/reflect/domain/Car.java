package com.jmye.spring6.reflect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/29 17:27
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private String name;
    private int age;
    private String color;

    private void run(){
        System.out.println("私有方法 run ...");
    }
}
