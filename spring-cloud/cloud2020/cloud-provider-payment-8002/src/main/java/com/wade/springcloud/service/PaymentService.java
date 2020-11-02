package com.wade.springcloud.service;

import com.wade.springcloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
