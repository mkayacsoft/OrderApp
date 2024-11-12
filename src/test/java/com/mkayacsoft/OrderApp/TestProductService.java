package com.mkayacsoft.OrderApp;

import com.mkayacsoft.OrderApp.dto.DTOProduct;
import com.mkayacsoft.OrderApp.dto.dtoIU.DTOProductIU;
import com.mkayacsoft.OrderApp.mapper.ProductMapper;
import com.mkayacsoft.OrderApp.model.Product;
import com.mkayacsoft.OrderApp.repository.ProductRepository;
import com.mkayacsoft.OrderApp.services.impl.ProductServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestProductService {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    private DTOProductIU dtoProductIU;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dtoProductIU = new DTOProductIU("New Product", "Description", new BigDecimal("100.00"), 10);
    }

    @Test
    public void testCreateProduct(){
        Product product = new Product();
        Product savedProduct= new Product(1L,"New Product","Description",new BigDecimal("100.00"),10);
        DTOProduct expectedDtoProduct = new DTOProduct(1L,"New Product","Description",new BigDecimal("100.00"),10);

        when(productMapper.DtoProductIUtoEntity(dtoProductIU)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(savedProduct);
        when(productMapper.entityToDtoProduct(savedProduct)).thenReturn(expectedDtoProduct);

        DTOProduct result =productService.createProduct(dtoProductIU);

        assertEquals(expectedDtoProduct,result);
        verify(productMapper).DtoProductIUtoEntity(dtoProductIU);
        verify(productRepository).save(product);
        verify(productMapper).entityToDtoProduct(savedProduct);

    }

    @Test
    public void testGetProductAll(){
        List<Product> productList = Arrays.asList(new Product(1L,"Product1","descrpProduct1",BigDecimal.valueOf(100),11));
        List<DTOProduct> expectedDtoList = Arrays.asList(new DTOProduct(1L,"Product1","descrpProduct1",BigDecimal.valueOf(100),11));

        when(productRepository.findAll()).thenReturn(productList);
        when(productMapper.toDtoProduct(productList)).thenReturn(expectedDtoList);

        List<DTOProduct> actualDtoList = productService.getProductAll();

        assertEquals(expectedDtoList, actualDtoList);

        verify(productRepository).findAll();
        verify(productMapper).toDtoProduct(productList);
    }
    @Test
    public void testGetById(){
        Long productId = 100L;
        Product mockProduct= new Product();
        DTOProduct mockDTOProduct = new DTOProduct();

        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));
        when(productMapper.entityToDtoProduct(mockProduct)).thenReturn(mockDTOProduct);

        DTOProduct result= productService.getProductById(productId);

        assertEquals(mockDTOProduct,result);
        verify(productRepository).findById(productId);
        verify(productMapper).entityToDtoProduct(mockProduct);
    }

    @Test
    public void testGetProductById_NotFound(){
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () ->{productService.getProductById(productId);});

        assertEquals("Product not found with id: " +productId, exception.getMessage());
        verify(productRepository).findById(productId);
    }


    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        DTOProductIU dtoProductIU = new DTOProductIU("Updated Product", "Updated Description", new BigDecimal("200"), 20);
        Product existingProduct = new Product(productId, "Old Product", "Old Description", new BigDecimal("100"), 10);
        Product updatedProduct = new Product(productId, "Updated Product", "Updated Description", new BigDecimal("200"), 20);
        DTOProduct expectedDtoProduct = new DTOProduct(productId, "Updated Product", "Updated Description", new BigDecimal("200"), 20);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);
        when(productMapper.entityToDtoProduct(updatedProduct)).thenReturn(expectedDtoProduct);

        DTOProduct actualDtoProduct = productService.updateProduct(productId, dtoProductIU);

        assertEquals(expectedDtoProduct, actualDtoProduct);
        verify(productRepository).findById(productId);
        verify(productMapper).DtoProductIUtoEntityUpdate(dtoProductIU, existingProduct);
        verify(productRepository).save(existingProduct);
        verify(productMapper).entityToDtoProduct(updatedProduct);
    }

    @Test
    public void testUpdateProduct_NotFound() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            productService.updateProduct(productId, dtoProductIU);
        });

        assertEquals("Product not found with id" + productId, exception.getMessage());
        verify(productRepository).findById(productId);
    }

    @Test
    public void testDeleteProduct(){
         Long productId = 1L;

         productService.deleteProduct(productId);

         verify(productRepository).deleteById(productId);
    }



}
