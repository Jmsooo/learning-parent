package com.jmye.mybatis.ipersistence.test;

import com.jmye.mybatis.ipersistence.io.Resources;
import com.jmye.mybatis.ipersistence.sqlSession.SqlSession;
import com.jmye.mybatis.ipersistence.sqlSession.SqlSessionFactory;
import com.jmye.mybatis.ipersistence.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:25
 * @Version 1.0
 */
public class IPersistenceTest {
    public static void main(String[] args) throws PropertyVetoException, DocumentException, ClassNotFoundException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 调用
        // sqlSession.selectOne("user.selectOne")
    }
}
