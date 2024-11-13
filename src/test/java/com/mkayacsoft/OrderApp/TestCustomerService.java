package com.mkayacsoft.OrderApp;

import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;
import com.mkayacsoft.OrderApp.mapper.CustomerMapper;
import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.repository.CustomerRepository;
import com.mkayacsoft.OrderApp.services.impl.CustomerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.boot.model.source.spi.AssociationSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


public class TestCustomerService {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;

    private DTOCustomerIU dtoCustomerIU;
    private Customer customer;
    private DTOCustomer dtoCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dtoCustomerIU = new DTOCustomerIU("John Doe", "john@example.com", true);
        customer = new Customer(1L, "John Doe", "john@example.com", true,null);
        dtoCustomer = new DTOCustomer(1L, "John Doe", "john@example.com", true);

    }

    @Test
    void testCreateCustomer(){

        when(customerMapper.dtoCustomerIUtoCustomer(dtoCustomerIU)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerMapper.customerToDtoCustomer(customer)).thenReturn(dtoCustomer);

        DTOCustomer result = customerService.createCustomer(dtoCustomerIU);

        Assertions.assertEquals(dtoCustomer,result);
        verify(customerMapper).dtoCustomerIUtoCustomer(dtoCustomerIU);
        verify(customerRepository).save(customer);
        verify(customerMapper).customerToDtoCustomer(customer);

    }

    @Test
    void testUpdateCustomer(){
        Long id =1L;
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
        doNothing().when(customerMapper).DtoCustomerIUtoEntityUpdate(dtoCustomerIU,customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerMapper.customerToDtoCustomer(customer)).thenReturn(dtoCustomer);

        DTOCustomer result = customerService.updateCustomer(id,dtoCustomerIU);

        Assertions.assertEquals(dtoCustomer,result);
        verify(customerRepository).findById(id);
        verify(customerMapper).DtoCustomerIUtoEntityUpdate(dtoCustomerIU,customer);
        verify(customerRepository).save(customer);
        verify(customerMapper).customerToDtoCustomer(customer);

    }

    @Test
    void testDeleteByIdCustomer(){
        Long id =1L;
        doNothing().when(customerRepository).deleteById(id);
        customerService.deleteCustomer(id);
        verify(customerRepository).deleteById(id);
    }

    @Test
    void testGetCustomerById(){
        Long id =1L;
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
        when(customerMapper.customerToDtoCustomer(customer)).thenReturn(dtoCustomer);

        DTOCustomer result = customerService.getCustomerById(id);

        Assertions.assertEquals(dtoCustomer,result);
        verify(customerRepository).findById(id);
        verify(customerMapper).customerToDtoCustomer(customer);
    }

    @Test
    void testGetCustomerById_NotFound(){
        Long id=1L;
        when(customerRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class,()->customerService.getCustomerById(id));
        verify(customerRepository).findById(id);
    }

    @Test
    void testGetAllCustomer(){
        List<Customer> customerList = Arrays.asList(customer);
        List<DTOCustomer> dtoCustomerList = Arrays.asList(dtoCustomer);

        when(customerRepository.findAll()).thenReturn(customerList);
        when(customerMapper.ListCustomerToListDtoCustomer(customerList)).thenReturn(dtoCustomerList);

        List<DTOCustomer> result = customerService.getAllCustomer();

        Assertions.assertEquals(dtoCustomerList,result);
        verify(customerRepository).findAll();
        verify(customerMapper).ListCustomerToListDtoCustomer(customerList);
    }

    @Test
    void testAddOrderPermission(){
        Long id = 1L;
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
        customer.setOrderAuthority(true);
        when(customerRepository.save(customer)).thenReturn(customer);


        Assertions.assertEquals(true,customer.getOrderAuthority());
        verify(customerRepository).findById(id);
        verify(customerRepository).save(customer);
    }
}
