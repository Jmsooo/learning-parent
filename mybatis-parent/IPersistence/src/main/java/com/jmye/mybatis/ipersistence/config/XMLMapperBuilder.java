package com.jmye.mybatis.ipersistence.config;

import com.jmye.mybatis.ipersistence.pojo.Configuration;
import com.jmye.mybatis.ipersistence.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 23:44
 * @Version 1.0
 */
public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parseMapper(InputStream inputStream) throws DocumentException, ClassNotFoundException {
        Document document = new SAXReader().read(inputStream);

        // 根标签: mapper
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");

        List<Element> selectNodes = rootElement.selectNodes("//select");
        for (Element element : selectNodes) {
            String id = element.attributeValue("id");
            String parameterType = element.attributeValue("parameterType");
            String resultType = element.attributeValue("resultType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParameterType(Class.forName(parameterType));
            mappedStatement.setResultType(Class.forName(resultType));
            mappedStatement.setSql(sqlText);

            String key = namespace + "." + id;
            configuration.getMappedStatementMap().put(key, mappedStatement);
        }
    }
}
