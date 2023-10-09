package com.jmye.spring6.jdbc.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 22:27
 * @Version 1.0
 */
@Data
@ToString
public class Emp {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
