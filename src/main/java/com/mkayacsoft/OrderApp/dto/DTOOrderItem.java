package com.mkayacsoft.OrderApp.dto;

import com.mkayacsoft.OrderApp.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOOrderItem {
    private Integer quantity;
    private Long productId;
}
