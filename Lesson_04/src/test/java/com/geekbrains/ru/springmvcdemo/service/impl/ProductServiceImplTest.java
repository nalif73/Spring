package com.geekbrains.ru.springmvcdemo.service.impl;

import com.geekbrains.ru.springmvcdemo.SpringMvcDemoApplicationTest;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class ProductServiceImplTest extends SpringMvcDemoApplicationTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
//        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
//        productService = new ProductServiceImpl(productRepository);

        Mockito.when(productRepository.findById(Mockito.anyInt()))
                .thenReturn(java.util.Optional.of(new Product(1L, "test", 20)));
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}