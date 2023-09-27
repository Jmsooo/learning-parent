package com.jmye.spring6.ioc.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/28 00:02
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@ToString
public class Teacher {
    private Integer teacherId;

    private String teacherName;
}
