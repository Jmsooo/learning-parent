package com.jmye.boot.demo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/17 20:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "abc")
public class AbcTest {

    @Autowired
    private Environment environment;

    @Value("${abc.name}")
    private String name;

    @Value("${abc.age}")
    private Integer age;

    @Value("${abc.address}")
    private List<String> address;

    public void print(){
        System.out.println(environment.getProperty("abc.name"));
    }


}
