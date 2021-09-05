package com.springboot.springbootapp.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.springboot.springbootapp.exception.ProductNotFoundException;
import com.springboot.springbootapp.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
  
    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product(); 
        honey.setId("1"); 
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @Override
    public Collection<Product> getProducts() {
        logger.info("Returning all products.");
        return productRepo.values();
    }

    @Override
    public void createProduct(Product product) {
        logger.info("Adding a product.");
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        logger.info("Updating a product.");
        if(!productRepo.containsKey(id))
            throw new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);    
    }

    @Override
    public void deleteProduct(String id) {
        logger.info("Deleting a product.");
        if(!productRepo.containsKey(id))
            throw new ProductNotFoundException();
        productRepo.remove(id);
    }
    
}
