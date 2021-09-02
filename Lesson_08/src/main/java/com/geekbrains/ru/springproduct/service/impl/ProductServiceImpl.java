package com.geekbrains.ru.springproduct.service.impl;

import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.repository.ProductRepository;
import com.geekbrains.ru.springproduct.service.ProductService;
import com.geekbrains.ru.springproduct.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.nio.file.Path;
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

    @Override
    @Transactional
    public Product saveWithImage(Product product, MultipartFile image) {
        Product savedProduct = productRepository.save(product);

        if (image != null && !image.isEmpty()) {
            Path pathImage = FileUtils.saveProductImage(image);
            savedProduct.setImageLink(pathImage.toString());

            productRepository.save(savedProduct);
        }

        return savedProduct;
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

}