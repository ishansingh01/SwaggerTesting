package com.ishan.swaggertesting.controller;


import com.ishan.swaggertesting.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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


    Map<Long,Product> map = new HashMap<>();

    Product product1 = new Product(1L, "AC", 40000);
    Product product2 = new Product(2L, "TV", 30000);

    @GetMapping
    @Operation(summary = "Get all product in application", description = "returns all product")
    public List<Product> getAllProducts() {
        map.put(product1.getId(),product1);
        map.put(product2.getId(),product2);
        return new ArrayList<>(map.values());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product By ID", description = "return Product By Id")
    public Product getProductsById(@PathVariable Long id) {
        return map.get(id);//by index not long id in Product
    }

    @PostMapping()
    @Operation(summary = "Add new product ", description = "Add Product  in Db")
    public Product addProduct(@RequestBody Product newProduct) {
        map.put(newProduct.getId(),newProduct);
        return newProduct;
    }
}
