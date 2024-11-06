package com.mkayacsoft.OrderApp.dto.dtoIU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOOrderItemIU {
    private Integer quantity;
    private Long productId;
}
