package com.springboot.springbootapp.controller;

import java.util.Map;
import java.util.HashMap;

import com.springboot.springbootapp.exception.ProductNotFoundException;
import com.springboot.springbootapp.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class ProductServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class); 

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

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct() {
        logger.info("Returning all products.");
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    } 


    @RequestMapping(value="/products", method=RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        logger.info("Adding a product.");
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.info("Updating a product.");
        if(!productRepo.containsKey(id))
            throw new ProductNotFoundException();
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully.", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        logger.info("Deleting a product.");
        if(!productRepo.containsKey(id))
            throw new ProductNotFoundException();
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully.", HttpStatus.OK);
    }

}
