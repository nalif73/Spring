package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.repository.ProductRepository;
import com.geekbrains.ru.springproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product save(Product productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public Page<Product> findAllByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> findMinPrice(double price) {
        return productRepository.findAllByPriceLessThan(price);
    }

    public List<Product> findMaxPrice(double price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }


}