package com.wfigura.os.api.repository;

import com.wfigura.os.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//Order -> type of data, Integer -> type of primary key
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
