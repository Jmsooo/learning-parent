package com.jmye.spring6.ioc.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 23:44
 * @Version 1.0
 */
@Data
// @AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Clazz {
    private Integer clazzId;

    private String clazzName;

    private List<Student> students;
}
