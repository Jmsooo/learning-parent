package com.jmye.mybatis.ipersistence.sqlSession;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:50
 * @Version 1.0
 */
public interface SqlSessionFactory {
    public SqlSession openSession();
}
