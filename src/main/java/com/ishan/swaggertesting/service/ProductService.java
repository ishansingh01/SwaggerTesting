package com.ishan.swaggertesting.service;


import com.ishan.swaggertesting.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    Map<Long,Product> map = new HashMap<>();

    Product product1 = new Product(1L, "AC", 40000);
    Product product2 = new Product(2L, "TV", 30000);

    public List<Product> getAll() {

        map.put(product1.getId(),product1);
        map.put(product2.getId(),product2);
        return new ArrayList<>(map.values());
    }

    public Product getProductById(Long id) {
        return map.get(id);
    }

    public Product addProduct(Product newProduct) {
        map.put(newProduct.getId(),newProduct);
        return newProduct;
    }
}
