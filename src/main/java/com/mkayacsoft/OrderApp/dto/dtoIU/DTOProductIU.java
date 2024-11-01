package com.mkayacsoft.OrderApp.dto.dtoIU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOProductIU {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}