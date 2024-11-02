package com.mkayacsoft.OrderApp.repository;

import com.mkayacsoft.OrderApp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
