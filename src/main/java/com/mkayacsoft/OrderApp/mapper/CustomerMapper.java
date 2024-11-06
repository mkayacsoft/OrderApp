package com.mkayacsoft.OrderApp.mapper;

import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;
import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer dtoCustomerIUtoCustomer(DTOCustomerIU dtoCustomerIU);
    DTOCustomer customerToDtoCustomer(Customer entity);
    void DtoCustomerIUtoEntityUpdate(DTOCustomerIU dtoCustomerIU, @MappingTarget Customer customer);
    List<DTOCustomer> ListCustomerToListDtoCustomer(List<Customer> customerList);

}
