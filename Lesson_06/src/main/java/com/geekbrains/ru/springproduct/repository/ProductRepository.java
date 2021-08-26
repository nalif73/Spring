package com.geekbrains.ru.springproduct.repository;


import com.geekbrains.ru.springproduct.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(long id);

    Product save(Product product);
}
