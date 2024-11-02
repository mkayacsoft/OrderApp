package com.mkayacsoft.OrderApp.repository;

import com.mkayacsoft.OrderApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
