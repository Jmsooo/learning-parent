package com.jmye.cloud.repository;

import com.jmye.cloud.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/5 19:08
 * @Version 1.0
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
