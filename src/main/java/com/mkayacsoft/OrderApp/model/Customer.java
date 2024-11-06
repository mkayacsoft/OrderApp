package com.mkayacsoft.OrderApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "order_authority")
    private Boolean orderAuthority;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Boolean isOrderAuthority(){
        return  orderAuthority;
    }
}
