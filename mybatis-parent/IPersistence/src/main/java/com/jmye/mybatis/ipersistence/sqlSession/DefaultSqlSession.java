package com.jmye.mybatis.ipersistence.sqlSession;

import com.jmye.mybatis.ipersistence.pojo.Configuration;
import com.jmye.mybatis.ipersistence.pojo.MappedStatement;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/11 00:11
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String statementId, Object... params) {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        return simpleExecutor.query(configuration, mappedStatement, params);
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) {
        List<Object> objects = selectList(statementId, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果为空或返回结果过多!");
        }
    }
}
