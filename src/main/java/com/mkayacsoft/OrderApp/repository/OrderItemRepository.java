package com.mkayacsoft.OrderApp.repository;

import com.mkayacsoft.OrderApp.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
}
