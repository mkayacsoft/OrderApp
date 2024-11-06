package com.mkayacsoft.OrderApp.repository;

import com.mkayacsoft.OrderApp.model.Order;
import com.mkayacsoft.OrderApp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomerId(Long customerId);
}
