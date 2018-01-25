package com.german.spring.microservices.demo.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDiscoverer {

    @Autowired
    DiscoveryClient discoveryClient;

    public ServiceInstance getServiceInstance(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        return instances
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Service [%s] not found", serviceName)));
    }
}