package com.geekbrains.ru.springproduct.repository;


import com.geekbrains.ru.springproduct.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    //    List<Product> findAllByPriceLessThan(double price);
    List<Product> findAllByPriceLessThan(double price);

    List<Product> findAllByPriceGreaterThan(double price);


}
