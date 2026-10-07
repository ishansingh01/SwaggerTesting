package com.ishan.swaggertesting.controller;


import com.ishan.swaggertesting.entity.Product;
import com.ishan.swaggertesting.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Product API", description = "Operation Related to Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    @Operation(summary = "Get all product in application", description = "returns all product")
    public List<Product> getAllProducts() {
        System.out.println("Get all products in application");
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product By ID", description = "return Product By Id")
    public Product getProductsById(@PathVariable Long id) {
        System.out.println("Get product by ID");
        return productService.getProductById(id);//by index not long id in Product
    }

    @PostMapping()
    @Operation(summary = "Add new product ", description = "Add Product  in Db")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }
}
