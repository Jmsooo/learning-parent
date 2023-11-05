package com.jmye.cloud.controller;

import com.jmye.cloud.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/5 20:01
 * @Version 1.0
 */
@RequestMapping("/consumer/depart")
@RestController
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    // private static final String SERVICE_PROVIDER = "http://127.0.0.1:8081/provider/depart";
    private static final String SERVICE_PROVIDER = "http://nacos-provider-depart/provider/depart";

    @PostMapping("/save")
    public boolean save(@RequestBody Depart depart) {
        String URL = SERVICE_PROVIDER + "/save";
        return restTemplate.postForObject(URL, depart, Boolean.class);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        restTemplate.delete(SERVICE_PROVIDER + "/delete/" + id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Depart depart) {
        String URL = SERVICE_PROVIDER + "/update";
        restTemplate.put(URL, depart);
    }

    @GetMapping("/get/{id}")
    public Depart get(@PathVariable("id") int id) {
        String URL = SERVICE_PROVIDER + "/get/" + id;
        return restTemplate.getForObject(URL, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> list() {
        String URL = SERVICE_PROVIDER + "/list";
        return restTemplate.getForObject(URL, List.class);
    }

}
