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
        products.add(new Product(1L, "Яблоко", 20.2));
        products.add(new Product(2L, "Груша", 12.6));
        products.add(new Product(3L, "Дыня", 54.32));
        products.add(new Product(4L, "Арбуз", 65.3));
        products.add(new Product(5L, "Малина", 100.5));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
