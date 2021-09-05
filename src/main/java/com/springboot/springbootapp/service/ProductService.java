package com.springboot.springbootapp.service;

import java.util.Collection;

import com.springboot.springbootapp.model.Product;

public interface ProductService {
    
    public abstract Collection<Product> getProducts();

    public abstract void createProduct(Product product);

    public abstract void updateProduct(String id, Product product);

    public abstract void deleteProduct(String id);

}
