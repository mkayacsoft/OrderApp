package com.mkayacsoft.OrderApp.controller;

import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderIU;

import java.util.List;

public interface IOrderController {

    DTOOrder createOrder(Long customerId, DTOOrderIU dtoOrderIU);
    List<DTOOrder> getOrdersByCustomer(Long customerId);
    DTOOrder getOrderById(Long orderId);
    DTOOrder updateOrder(Long orderId,DTOOrderIU dtoOrderIU);
    void deleteOrder(Long orderId);
}
