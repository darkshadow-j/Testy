package com.pawel.homework10.service;

import com.pawel.homework10.jpa.ProductDAO;
import com.pawel.homework10.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product addProductToList(Product product) {
       return productDAO.save(product);
    }

    @Override
    public Product editProductInList(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }

    @Override
    public List<Product> showProductsList() {
        return productDAO.findAll();
    }
}
