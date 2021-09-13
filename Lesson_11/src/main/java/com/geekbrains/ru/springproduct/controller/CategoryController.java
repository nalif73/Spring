package com.geekbrains.ru.springproduct.controller;



import com.geekbrains.ru.springproduct.domain.CategoryEntity;
import com.geekbrains.ru.springproduct.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String findCategories(Model model) {

        List<CategoryEntity> categoryList = categoryService.findAll();

        model.addAttribute("categoryList", categoryList);

        return "category/list";
    }

    }



