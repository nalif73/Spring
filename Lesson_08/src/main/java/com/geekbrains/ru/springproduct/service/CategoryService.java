package com.geekbrains.ru.springproduct.service;


import com.geekbrains.ru.springproduct.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

 //   Category findByAlias(String alias);

    Category save(Category category);

    Page<Category> findAllByPage(Pageable pageable);
}
