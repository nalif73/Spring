package com.geekbrains.ru.springproduct.controller;

import com.geekbrains.ru.springproduct.SpringMvcDemoApplicationTest;
import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest extends SpringMvcDemoApplicationTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @BeforeEach
//    void setUp() {
//        Product product = new Product(1L, "title", 20, 1);
//
//        Mockito.when(productService.findAll())
//                .thenReturn(Collections.singletonList(product));
//    }
//
//    @Test
//    void getProducts() throws Exception {
//        Product product = new Product(1L, "title", 20,1);
//
//        mockMvc.perform(get("/product"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("products"))
//                .andExpect(model().attribute("products", Collections.singletonList(product)));
//
//    }
//
//    @Test
//    void correctAddProducts() throws Exception {
//        Product product = new Product(1L, "title", 20, 1);
//
//        mockMvc.perform(post("/product")
//                        .param("id", "1")
//                        .param("name", "title")
//                        .param("price", "20"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/product"));
//
//        Mockito.verify(productService, Mockito.times(1)).save(product);
//    }
//
//    @Test
//    void addProductsWithoutId() throws Exception {
//        mockMvc.perform(post("/product")
//                        .param("name", "title")
//                        .param("price", "20"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("error"));
//    }
//
//    @Test
//    void addProductsWithoutName() throws Exception {
//        mockMvc.perform(post("/product")
//                        .param("id", "1")
//                        .param("name", "")
//                        .param("price", "20"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/product/add"))
//                .andExpect(flash().attribute("error", "Name не может быть пустым"));
//    }

}