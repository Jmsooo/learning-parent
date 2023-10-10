package com.jmye.mybatis.ipersistence.sqlSession;

import com.jmye.mybatis.ipersistence.config.XMLConfigBuilder;
import com.jmye.mybatis.ipersistence.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:50
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException, ClassNotFoundException {
        // 1.使用dom4j解析配置文件, 将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        // 2.创建SqlSessionFactory对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);


        return defaultSqlSessionFactory;
    }
}
