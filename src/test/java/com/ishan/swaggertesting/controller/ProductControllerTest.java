package com.ishan.swaggertesting.controller;

import com.ishan.swaggertesting.entity.Product;
import com.ishan.swaggertesting.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp(){
        System.out.println("Hello buddy i am running....");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAllProducts(){
        List<Product> mockList = List.of(
                new Product(1L, "pen", 10),
                new Product(2L, "NoteBook", 100)
        );
        when(productService.getAll()).thenReturn(mockList);

        List<Product> all = productController.getAllProducts();
        assertEquals(2, all.size());
        assertEquals("pen", all.get(0).getName());
    }

    @Test
    void testGetProductById(){
        Product product = new Product(4L, "Laptop", 100000);
        when(productService.getProductById(4L)).thenReturn(product);

        Product productsById = productController.getProductsById(4L);
        assertEquals("Laptop", productsById.getName());
        assertEquals(100000, productsById.getAmount());
    }
}
