package com.pawel.homework10.controller;

import com.pawel.homework10.model.Product;
import com.pawel.homework10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.showProductsList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("id") Long id){
        return new ResponseEntity<Product>(productService.getProductById(id) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.addProductToList(product), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.editProductInList(product), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
