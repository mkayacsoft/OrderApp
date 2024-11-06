package com.mkayacsoft.OrderApp.services;


import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderIU;

import java.util.List;

public interface IOrderService {

    DTOOrder createOrder(Long customerId, DTOOrderIU dtoOrderIU);
    List<DTOOrder> getOrdersByCustomer(Long customerId);
    DTOOrder getOrderById(Long orderId);
    DTOOrder updateOrder(Long orderId,DTOOrderIU dtoOrderIU);
    void deleteOrder(Long orderId);

}
