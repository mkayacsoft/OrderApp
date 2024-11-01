package com.mkayacsoft.OrderApp.dto.dtoIU;

import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOOrderIU {
    private List<OrderItem> items;
    private Long customerId;
}
