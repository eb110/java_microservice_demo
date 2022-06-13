package com.wfigura.ps.api.service;

import com.wfigura.ps.api.entity.Payment;
import com.wfigura.ps.api.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public String paymentProcessing(){
        //api should be the 3rd party payment service (paypal, util bills...)
        return new Random().nextBoolean() ? "Success" : "False";
    }
}
