package com.jmye.mybatis.ipersistence.sqlSession;

import com.jmye.mybatis.ipersistence.pojo.Configuration;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/11 00:09
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
