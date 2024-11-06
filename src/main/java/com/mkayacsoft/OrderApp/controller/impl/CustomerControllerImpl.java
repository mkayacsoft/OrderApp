package com.mkayacsoft.OrderApp.controller.impl;

import com.mkayacsoft.OrderApp.controller.ICustomerController;
import com.mkayacsoft.OrderApp.dto.DTOCustomer;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;
import com.mkayacsoft.OrderApp.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements ICustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    @Override
    public DTOCustomer createCustomer(@RequestBody DTOCustomerIU dtoCustomerIU) {
        return customerService.createCustomer(dtoCustomerIU);
    }

    @PutMapping("/update/{id}")
    @Override
    public DTOCustomer updateCustomer(@PathVariable Long id, @RequestBody DTOCustomerIU dtoCustomerIU) {
        return customerService.updateCustomer(id,dtoCustomerIU);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    @Override
    public DTOCustomer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/all")
    @Override
    public List<DTOCustomer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/{id}/order-permission")
    @Override
    public void addOrderPermission(@PathVariable Long customerId) {
        customerService.addOrderPermission(customerId);
    }
}
