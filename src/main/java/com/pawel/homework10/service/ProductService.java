package com.pawel.homework10.service;

import com.pawel.homework10.model.Product;

import java.util.List;

public interface ProductService {

    Product addProductToList(Product product);
    Product editProductInList(Product product);
    Product getProductById(Long id);
    void deleteProduct(Product product);
    List<Product> showProductsList();

}
