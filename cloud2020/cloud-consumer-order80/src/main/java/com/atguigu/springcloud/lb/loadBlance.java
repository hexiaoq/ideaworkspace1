package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface loadBlance {
    public ServiceInstance instance(List<ServiceInstance> serviceInstances);



}
