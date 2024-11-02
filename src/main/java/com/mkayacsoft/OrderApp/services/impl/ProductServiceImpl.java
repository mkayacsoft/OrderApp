package com.mkayacsoft.OrderApp.services.impl;

import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;
import com.mkayacsoft.OrderApp.mapper.ProductMapper;
import com.mkayacsoft.OrderApp.model.Product;
import com.mkayacsoft.OrderApp.repository.ProductRepository;
import com.mkayacsoft.OrderApp.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<DTOProduct> getProductAll() {

        List<Product> productList = productRepository.findAll();
        return productMapper.toDtoProduct(productList);
    }
    @Override
    public DTOProduct getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return productMapper.entityToDtoProduct(product);
    }
    @Override
    public DTOProduct createProduct(DTOProductIU dtoProductIU) {
        Product product = productMapper.DtoProductIUtoEntity(dtoProductIU);
        Product productDb = productRepository.save(product);
        return productMapper.entityToDtoProduct(productDb);
    }

    @Override
    public DTOProduct updateProduct(Long id, DTOProductIU dtoProductIU) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Product not found with id"+id));
        productMapper.DtoProductIUtoEntityUpdate(dtoProductIU,product);
        Product updateProduct = productRepository.save(product);
        return productMapper.entityToDtoProduct(updateProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
