package com.mkayacsoft.OrderApp.controller;

import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;

import java.util.List;

public interface IProductController {
    public List<DTOProduct> getProductAll();
    public DTOProduct getProductById(Long id);
    public DTOProduct createProduct(DTOProductIU dtoProductIU);
    public DTOProduct updateProduct(Long id,DTOProductIU dtoProductIU);
    public void deleteProduct(Long id);


}
