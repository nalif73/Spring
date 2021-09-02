package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;



public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Product save(Product productEntity);

    Page<Product> findAllByPage(Pageable pageable);

    List<Product> findMaxPrice(double price);

    List<Product> findMinPrice(double price);

    Product saveWithImage(Product product, MultipartFile image);

    void deleteById(Long productId);
}
