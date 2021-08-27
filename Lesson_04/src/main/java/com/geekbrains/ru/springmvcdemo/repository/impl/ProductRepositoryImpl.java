package com.geekbrains.ru.springmvcdemo.repository.impl;


import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "title", 20.2));
        products.add(new Product(2, "title", 20.2));
        products.add(new Product(3, "title", 20.2));
        products.add(new Product(4, "title", 20.2));
        products.add(new Product(5, "title", 20.2));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }
}
