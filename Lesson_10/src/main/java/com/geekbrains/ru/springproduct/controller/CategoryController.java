package com.geekbrains.ru.springproduct.controller;



import com.geekbrains.ru.springproduct.domain.Category;
import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

//    @GetMapping
//    public String getCategoryByAlias(@RequestParam("alias") String categoryAlias, Model model) {
//        CategoryEntity categoryByAlias = categoryService.findByAlias(categoryAlias);
//
//        model.addAttribute("category", categoryByAlias);
//
//        return "category/detail";
//    }

    @GetMapping("")
    public List<Category> getAllProducts() {
        return categoryService.findAll();
    }

    }



