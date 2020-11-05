package com.wade.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wade.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 成功
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }

    /**
     * 失败
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOutHandler,id：  " + id + "\t" + "哇giao";
    }


}
