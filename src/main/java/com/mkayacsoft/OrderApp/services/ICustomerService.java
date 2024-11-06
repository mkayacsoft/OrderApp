package com.mkayacsoft.OrderApp.services;

import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;

import java.util.List;

public interface ICustomerService {
    DTOCustomer createCustomer(DTOCustomerIU dtoCustomerIU);
    DTOCustomer updateCustomer(Long id, DTOCustomerIU dtoCustomerIU);
    void deleteCustomer(Long id);
    DTOCustomer getCustomerById(Long id);
    List<DTOCustomer> getAllCustomer();
    void addOrderPermission(Long customerId);

}
