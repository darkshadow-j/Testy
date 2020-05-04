package com.pawel.homework10.jpa;

import com.pawel.homework10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

}
