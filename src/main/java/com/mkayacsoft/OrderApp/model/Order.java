package com.mkayacsoft.OrderApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> items;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @PrePersist
    protected void onCreate(){
        this.orderDate=LocalDate.now();
    }
}
