package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.config.property.ApplicationServerConfig;
import com.geekbrains.ru.springmvcdemo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/main")
public class MainController {

//    @Autowired(required = false)
//    private Product simpleProduct;
//
//    @PostConstruct
//    private void init() {
//        System.err.println(simpleProduct);
//    }

    //GET http://localhost:8080/alpha
    @GetMapping("/alpha")
    @ResponseBody
    private String getAlpha() {
        return "Alpha";
    }

    //POST http://localhost:8080/alpha
    @PostMapping("/alpha")
    @ResponseBody
    private String postAlpha(@RequestBody Product product) {
        return product.toString();
    }


}
