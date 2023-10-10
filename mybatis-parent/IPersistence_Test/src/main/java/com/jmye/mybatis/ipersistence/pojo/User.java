package com.jmye.mybatis.ipersistence.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/10 22:02
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    // 主键标识
    private Integer id;
    //⽤户名
    private String username;
}
