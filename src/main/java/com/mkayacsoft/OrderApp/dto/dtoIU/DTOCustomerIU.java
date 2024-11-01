package com.mkayacsoft.OrderApp.dto.dtoIU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOCustomerIU {
    private String name;
    private String email;
    private Boolean orderAuthority;
}
