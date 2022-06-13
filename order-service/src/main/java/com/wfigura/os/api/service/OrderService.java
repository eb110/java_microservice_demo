package com.wfigura.os.api.service;

import com.wfigura.os.api.common.Payment;
import com.wfigura.os.api.common.TransactionRequest;
import com.wfigura.os.api.common.TransactionResponse;
import com.wfigura.os.api.entity.Order;
import com.wfigura.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Service -> let to import it by application-context
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate template;

    //functionality is a standard rest call which performs internal rest call
    public TransactionResponse saveOrder(TransactionRequest request){
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call -> url, request, response
        Payment paymentResponse = template.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class);
        response = paymentResponse.getPaymentStatus().equals("Success") ? "Payment process achieved" : "Payment process failed";
        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }
}
