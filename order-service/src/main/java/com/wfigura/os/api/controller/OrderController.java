package com.wfigura.os.api.controller;

import com.wfigura.os.api.common.Payment;
import com.wfigura.os.api.common.TransactionRequest;
import com.wfigura.os.api.common.TransactionResponse;
import com.wfigura.os.api.entity.Order;
import com.wfigura.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){

        return service.saveOrder(request);
    }
}
