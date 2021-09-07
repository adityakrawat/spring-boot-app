package com.springboot.springbootapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.springboot.springbootapp.dao.ProductRepository;
import com.springboot.springbootapp.exception.ProductNotFoundException;
import com.springboot.springbootapp.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepo;

    @Override
    public Collection<Product> getProducts() {
        logger.info("Returning all products.");
        Collection<Product> productLs = new ArrayList<>();
        productRepo.findAll().forEach(e -> productLs.add(e));
        return productLs;
    }

    @Override
    public void createProduct(Product product) {
        logger.info("Adding a product.");
        productRepo.save(product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        logger.info("Updating a product.");
        Optional<Product> productOpt = productRepo.findById(id);
        if(!productOpt.isPresent())
            throw new ProductNotFoundException();
        productRepo.deleteById(id);
        productRepo.save(product);    
    }

    @Override
    public void deleteProduct(String id) {
        logger.info("Deleting a product.");
        Optional<Product> productOpt = productRepo.findById(id);
        if(!productOpt.isPresent())
            throw new ProductNotFoundException();
        productRepo.deleteById(id);
    }
    
}
