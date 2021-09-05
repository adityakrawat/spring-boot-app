package com.springboot.springbootapp.controller;

import com.springboot.springbootapp.model.Product;
import com.springboot.springbootapp.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProductService productService;

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    } 


    @RequestMapping(value="/products", method=RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully.", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully.", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully.", HttpStatus.OK);
    }

}
