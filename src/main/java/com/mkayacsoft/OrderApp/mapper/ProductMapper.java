package com.mkayacsoft.OrderApp.mapper;

import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;
import com.mkayacsoft.OrderApp.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<DTOProduct> toDtoProduct(List<Product> productList);
    void DtoProductIUtoEntityUpdate(DTOProductIU dtoProductIU, @MappingTarget Product product);
    Product DtoProductIUtoEntity(DTOProductIU dtoProductIU);
    DTOProduct entityToDtoProduct(Product product);
    Product entityToDtoProductIU(Product product);
}
