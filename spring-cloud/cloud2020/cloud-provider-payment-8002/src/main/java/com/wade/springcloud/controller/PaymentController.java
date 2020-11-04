package com.wade.springcloud.controller;

import com.wade.springcloud.entity.CommonResult;
import com.wade.springcloud.entity.Payment;
import com.wade.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        System.out.println("新增：" + serverPort);
        if (result > 0) {
            return new CommonResult<>(200, "新增成功", result);
        } else {
            return new CommonResult<>(201, "新增失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("查询：" + serverPort);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功：" + serverPort, payment);
        } else {
            return new CommonResult<>(201, "查询失败");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
