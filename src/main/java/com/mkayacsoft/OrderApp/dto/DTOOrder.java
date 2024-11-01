package com.mkayacsoft.OrderApp.dto;

import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOOrder {
    private Long id;
    private LocalDate orderDate;
    private List<OrderItem> items;
    private Long customerId;
}
