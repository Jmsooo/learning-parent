package com.jmye.mybatis.ipersistence.pojo;

import lombok.Data;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:28
 * @Version 1.0
 */
@Data
public class MappedStatement {
    private String id;
    private String sql;
    private Class<?> parameterType;
    private Class<?> resultType;
}
