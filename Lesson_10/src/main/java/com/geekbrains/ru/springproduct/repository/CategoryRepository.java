package com.geekbrains.ru.springproduct.repository;


import com.geekbrains.ru.springproduct.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Optional<Category> findByAlias(String alias);
}
