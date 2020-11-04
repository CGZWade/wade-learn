package com.wade.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalance implements LoadBalance {

    // 原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取第几次访问
     */
    private int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("************第几次访问next" + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标；服务重启，则重新从1开始计数n
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        // 得到服务器的下标位置
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
