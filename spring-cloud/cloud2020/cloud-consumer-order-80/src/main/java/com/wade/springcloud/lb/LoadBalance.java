package com.wade.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡接口
 */
public interface LoadBalance {

    /**
     * 收集服务器总共有多少台能够提供服务的机器，并放到list里面
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
