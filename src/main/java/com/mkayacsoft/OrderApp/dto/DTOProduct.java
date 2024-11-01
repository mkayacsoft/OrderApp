package com.mkayacsoft.OrderApp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOProduct {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}
