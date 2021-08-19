package com.geekbrains.ru.springmvcdemo.config;

import com.geekbrains.ru.springmvcdemo.config.property.ProductConfig;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "application.product", value = {"name", "price"})
    public Product simpleProduct(ProductConfig config) {
        return new Product(1, config.getName(), config.getPrice());
    }

}
