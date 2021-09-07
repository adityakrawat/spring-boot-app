package com.springboot.springbootapp.dao;

import com.springboot.springbootapp.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    
}
