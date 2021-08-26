package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(long id);

    Product save(Product product);

}
