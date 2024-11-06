package com.mkayacsoft.OrderApp.controller;

import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;

import java.util.List;

public interface ICustomerController {
    DTOCustomer createCustomer(DTOCustomerIU dtoCustomerIU);
    DTOCustomer updateCustomer(Long id, DTOCustomerIU dtoCustomerIU);
    void deleteCustomer(Long id);
    DTOCustomer getCustomerById(Long id);
    List<DTOCustomer> getAllCustomer();
    void addOrderPermission(Long customerId);
}
