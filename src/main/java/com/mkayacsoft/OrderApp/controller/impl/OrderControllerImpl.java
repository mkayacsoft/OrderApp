package com.mkayacsoft.OrderApp.controller.impl;

import com.mkayacsoft.OrderApp.controller.IOrderController;
import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderIU;
import com.mkayacsoft.OrderApp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderControllerImpl implements IOrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/customer/{customerId}")
    @Override
    public DTOOrder createOrder(@PathVariable Long customerId, @RequestBody DTOOrderIU dtoOrderIU) {
        return orderService.createOrder(customerId,dtoOrderIU);
    }

    @GetMapping("/customer/{customerId}")
    @Override
    public List<DTOOrder> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/{orderId}")
    @Override
    public DTOOrder getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    @Override
    public DTOOrder updateOrder(@PathVariable Long orderId, @RequestBody DTOOrderIU dtoOrderIU) {
        return orderService.updateOrder(orderId,dtoOrderIU);
    }

    @DeleteMapping("/{orderId}")
    @Override
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

}
