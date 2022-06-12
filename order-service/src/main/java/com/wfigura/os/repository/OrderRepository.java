package com.wfigura.os.repository;

import com.wfigura.os.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//Order -> type of data, Integer -> type of primary key
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
