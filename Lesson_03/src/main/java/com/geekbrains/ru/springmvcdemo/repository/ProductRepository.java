package com.geekbrains.ru.springmvcdemo.repository;


import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void addProduct(Product product);

    void removeProduct(Long id);
}
