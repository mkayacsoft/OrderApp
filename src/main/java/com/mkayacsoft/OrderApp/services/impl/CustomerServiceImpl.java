package com.mkayacsoft.OrderApp.services.impl;

import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;
import com.mkayacsoft.OrderApp.mapper.CustomerMapper;
import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.Product;
import com.mkayacsoft.OrderApp.repository.CustomerRepository;
import com.mkayacsoft.OrderApp.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public DTOCustomer createCustomer(DTOCustomerIU dtoCustomerIU) {
        Customer customer =customerMapper.dtoCustomerIUtoCustomer(dtoCustomerIU);
        Customer customerDb = customerRepository.save(customer);
        return customerMapper.customerToDtoCustomer(customerDb);
    }

    @Override
    public DTOCustomer updateCustomer(Long id, DTOCustomerIU dtoCustomerIU) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customerMapper.DtoCustomerIUtoEntityUpdate(dtoCustomerIU,customer);
        Customer updateProductDb = customerRepository.save(customer);
        return customerMapper.customerToDtoCustomer(updateProductDb);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public DTOCustomer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return customerMapper.customerToDtoCustomer(customer);
    }

    @Override
    public List<DTOCustomer> getAllCustomer() {
        List<Customer> dtoCustomerList = customerRepository.findAll();
        return customerMapper.ListCustomerToListDtoCustomer(dtoCustomerList);
    }

    @Override
    public void addOrderPermission(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.setOrderAuthority(true);
        customerRepository.save(customer);

    }
}
