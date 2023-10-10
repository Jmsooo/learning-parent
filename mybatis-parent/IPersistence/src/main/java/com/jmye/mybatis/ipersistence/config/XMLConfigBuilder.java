package com.jmye.mybatis.ipersistence.config;

import com.jmye.mybatis.ipersistence.io.Resources;
import com.jmye.mybatis.ipersistence.pojo.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:55
 * @Version 1.0
 */
public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * 使用dom4j解析配置文件, 封装Configuration对象
     *
     * @param inputStream
     * @return
     */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException, ClassNotFoundException {
        Document document = new SAXReader().read(inputStream);

        // 根标签: configuration
        Element rootElement = document.getRootElement();
        List<Element> propertyNodes = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : propertyNodes) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));

        configuration.setDataSource(comboPooledDataSource);

        // 解析mapper.xml
        List<Element> mapperNodes = rootElement.selectNodes("//mapper");
        for (Element element : mapperNodes) {
            String mapperPath = element.attributeValue("resource");
            InputStream mapperInputStream = Resources.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parseMapper(mapperInputStream);
        }

        return configuration;
    }
}
