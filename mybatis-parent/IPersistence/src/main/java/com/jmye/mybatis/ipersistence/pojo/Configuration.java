package com.jmye.mybatis.ipersistence.pojo;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:36
 * @Version 1.0
 */
@Data
public class Configuration {
    // 数据源
    private DataSource dataSource;

    // key: statementId, value: MappedStatement
    private Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
