package com.geekbrains.ru.springproduct.controller;


import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.service.CategoryService;
import com.geekbrains.ru.springproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping
    public String getProducts(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "product/products";
    }

    @GetMapping("/add")
    public String addProduct(Model model, @ModelAttribute("error") String error) {
        model.addAttribute("product", new Product());
        model.addAttribute("error", error);


        return "product/add-product";
    }

    @GetMapping("/minprice")
    public String showMinPriceProduct(@RequestParam double price, Model model) {
        List<Product> products = productService.findMinPrice(price);
        model.addAttribute("products", products);
        return "product/products";
    }


    @GetMapping("/maxprice")
    public String showMaxPriceProduct(@RequestParam double price, Model model) {
        List<Product> products = productService.findMaxPrice(price);
        model.addAttribute("products", products);
        return "product/products";
    }


//    @GetMapping("/{id}")
//    public String getProduct(Model model, @PathVariable Long id) {
//        Product product = productService.findById(id).orElseThrow(IllegalArgumentException::new);
//
//        model.addAttribute("product", product);
//        return "/product";
//    }

    @PostMapping
    public RedirectView saveProduct(@ModelAttribute Product product, RedirectAttributes attributes) {
        if (product.getName().isEmpty()) {
            attributes.addFlashAttribute("error", "Name не может быть пустым");
            return new RedirectView("/product/add");
        }

//        if (product.getId() == null) {
//            throw new IllegalArgumentException();
//        }

        productService.save(product);

        return new RedirectView("/product");
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        System.err.println("Request: " + req.getRequestURL() + " raised " + ex);

        return "error";
    }

}
