package com.mkayacsoft.OrderApp.services.impl;

import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.DTOOrderItem;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderIU;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderItemIU;
import com.mkayacsoft.OrderApp.mapper.OrderMapper;
import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.Order;
import com.mkayacsoft.OrderApp.model.OrderItem;
import com.mkayacsoft.OrderApp.model.Product;
import com.mkayacsoft.OrderApp.repository.CustomerRepository;
import com.mkayacsoft.OrderApp.repository.OrderItemRepository;
import com.mkayacsoft.OrderApp.repository.OrderRepository;
import com.mkayacsoft.OrderApp.repository.ProductRepository;
import com.mkayacsoft.OrderApp.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public DTOOrder createOrder(Long customerId, DTOOrderIU dtoOrderIU) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        if (!customer.isOrderAuthority()) {
            throw new RuntimeException("Customer does not have authority");
        }

        Order order = orderMapper.toOrder(dtoOrderIU);
        order.setCustomer(customer);

        List<OrderItem> orderItems = new ArrayList<>();

        for (DTOOrderItemIU item : dtoOrderIU.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = orderMapper.toOrderItem(item);
            orderItem.setProduct(product);
            orderItem.setOrder(order);

            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        Order savedOrder = orderRepository.save(order);

        return orderMapper.toDtoOrder(savedOrder);
    }


    @Override
    public List<DTOOrder> getOrdersByCustomer(Long customerId) {
        List<Order> orderList = orderRepository.findByCustomerId(customerId);
        return orderMapper.orderListToDtoOrderList(orderList);
    }

    @Override
    public DTOOrder getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return orderMapper.toDtoOrder(order);
    }

    @Override
    public DTOOrder updateOrder(Long orderId, DTOOrderIU dtoOrderIU) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        orderMapper.DtoOrderIUtoEntityUpdate(dtoOrderIU,order);
        Order updateOrder = orderRepository.save(order);
        return orderMapper.toDtoOrder(updateOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
