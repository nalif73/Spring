package com.geekbrains.ru.springmvcdemo.repository.impl;

import com.geekbrains.ru.springmvcdemo.SpringMvcDemoApplication;
import com.geekbrains.ru.springmvcdemo.SpringMvcDemoApplicationTest;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class ProductRepositoryImplTest extends SpringMvcDemoApplicationTest {


 ProductRepositoryImpl productRepositoryImpl = Mockito.mock(ProductRepositoryImpl.class);



    @MockBean
    private List<Product> products;

   @MockBean
   Product product;

    @BeforeEach
    void setUp() throws Exception {
        products.add(new Product(1, "title1", 20.20));
        products.add(new Product(2, "title2", 20.30));

        Product product = new Product(2L, "title3", 40);

    }

    @Test
    void findAll() throws Exception {

        Mockito.when(productRepositoryImpl.findAll())
                .thenReturn(products);

    }

    @Test
    void findById() throws Exception {

        Mockito.when(productRepositoryImpl.findById(anyLong()))
                .thenReturn(java.util.Optional.ofNullable(product));



    }
}