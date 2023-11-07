package com.jmye.cloud.controller;

import com.jmye.cloud.bean.Depart;
import com.jmye.cloud.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/5 19:15
 * @Version 1.0
 */
@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService departService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/discovery")
    public List<String> discovery() {
        List<String> services = client.getServices();
        for (String serviceName : services) {
            List<ServiceInstance> instances = client.getInstances(serviceName);
            for (ServiceInstance instance : instances) {
                Map<String, Object> map = new HashMap<>();
                map.put("serviceName", serviceName);
                map.put("serviceId", instance.getInstanceId());
                map.put("host", instance.getHost());
                map.put("port", instance.getPort());
                map.put("uri", instance.getUri());
                System.out.println(map);
            }
        }
        return services;
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart get(@PathVariable("id") int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> list() {
        return departService.listAllDeparts();
    }

}
