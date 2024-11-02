package com.mkayacsoft.OrderApp.controller.impl;

import com.mkayacsoft.OrderApp.controller.IProductController;
import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;
import com.mkayacsoft.OrderApp.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements IProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/all")
    @Override
    public List<DTOProduct> getProductAll() {
        return productService.getProductAll() ;
    }

    @GetMapping("/{id}")
    @Override
    public DTOProduct getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/create")
    @Override
    public DTOProduct createProduct(@RequestBody DTOProductIU dtoProductIU) {
        return productService.createProduct(dtoProductIU);
    }
    @PutMapping("/update/{id}")
    @Override
    public DTOProduct updateProduct(@PathVariable Long id,@RequestBody DTOProductIU dtoProductIU) {
        return productService.updateProduct(id,dtoProductIU);
    }
    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
