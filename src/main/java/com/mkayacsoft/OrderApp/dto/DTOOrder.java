package com.mkayacsoft.OrderApp.dto;

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
    private List<DTOOrderItem> items;
    private Long customerId;
}
