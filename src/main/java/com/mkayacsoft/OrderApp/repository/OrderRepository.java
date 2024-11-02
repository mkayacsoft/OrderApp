package com.mkayacsoft.OrderApp.repository;

import com.mkayacsoft.OrderApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
