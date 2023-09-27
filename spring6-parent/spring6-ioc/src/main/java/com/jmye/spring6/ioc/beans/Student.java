package com.jmye.spring6.ioc.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 23:26
 * @Version 1.0
 */
@Data
// @AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Clazz clazz;

    private String[] hobbies;

    private Map<String, Teacher> teacherMap;
}
