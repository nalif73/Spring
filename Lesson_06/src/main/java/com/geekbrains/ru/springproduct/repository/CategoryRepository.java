package com.geekbrains.ru.springproduct.repository;


import com.geekbrains.ru.springproduct.domain.Category;


import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void addCategory(Category category);

    void initSession();

    void shutdown();
}
