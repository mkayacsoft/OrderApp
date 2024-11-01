package com.mkayacsoft.OrderApp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCustomer {
    private Long id;
    private String name;
    private String email;
    private Boolean orderAuthority;
}
