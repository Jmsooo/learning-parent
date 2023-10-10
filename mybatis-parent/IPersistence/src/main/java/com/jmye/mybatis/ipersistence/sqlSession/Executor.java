package com.jmye.mybatis.ipersistence.sqlSession;

import com.jmye.mybatis.ipersistence.pojo.Configuration;
import com.jmye.mybatis.ipersistence.pojo.MappedStatement;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/11 00:31
 * @Version 1.0
 */
public interface Executor {
    public <T> List<T> query(Configuration configuration, MappedStatement mappedStatement, Object... params);
}
