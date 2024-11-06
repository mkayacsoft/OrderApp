package com.mkayacsoft.OrderApp.mapper;

import com.mkayacsoft.OrderApp.dto.DTOOrder;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOCustomerIU;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderIU;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOOrderItemIU;
import com.mkayacsoft.OrderApp.model.Customer;
import com.mkayacsoft.OrderApp.model.Order;
import com.mkayacsoft.OrderApp.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(DTOOrderIU dtoOrderIU);
    @Mapping(source = "customer.id", target = "customerId")
    DTOOrder toDtoOrder(Order entity);
    DTOOrderItemIU toDtoOrderItemIU(Order entity);
    List<DTOOrder> orderListToDtoOrderList(List<Order> orderList);
    @Mapping(source = "dtoOrderIU.customerId", target = "customer.id")
    void DtoOrderIUtoEntityUpdate(DTOOrderIU dtoOrderIU, @MappingTarget Order order);
    @Mapping(source = "productId", target = "product.id") // productId'nin doğru eşlemesi
    OrderItem toOrderItem(DTOOrderItemIU dtoOrderItemIU);


}
