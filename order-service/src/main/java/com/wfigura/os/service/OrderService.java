package com.wfigura.os.service;

import com.wfigura.os.entity.Order;
import com.wfigura.os.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service -> let to import it by application-context
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order){
        return repository.save(order);
    }
}
