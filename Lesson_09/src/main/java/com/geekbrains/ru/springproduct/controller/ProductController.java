package com.geekbrains.ru.springproduct.controller;


import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.service.CategoryService;
import com.geekbrains.ru.springproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    private final Validator validator;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/minprice/{minPrice}")
    public List<Product> showMinPriceProduct(@PathVariable double minPrice) {

        return productService.findMinPrice(minPrice);

    }

    @GetMapping("/maxprice/{maxPrice}")
    public List<Product>  showMaxPriceProduct(@PathVariable double maxPrice) {
        return productService.findMaxPrice(maxPrice);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.save(product);
    }

    @GetMapping(value = "/delete/{id}")
        public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        System.err.println("Request: " + req.getRequestURL() + " raised " + ex);

        return "error";
    }

//    public RedirectView saveProduct(Product product,
//                                    @RequestParam(value = "image", required = false) MultipartFile image,
//                                    RedirectAttributes attributes) {
//
//        Set<ConstraintViolation<Product>> violationResult = validator.validate(product);
//        if (CollectionUtils.isNotEmpty(violationResult)) {
//            String violations = violationResult.stream()
//                    .map(ConstraintViolation::getMessage)
//                    .collect(Collectors.joining("\n"));
//
//            attributes.addFlashAttribute("violations", violations);
//
//            return new RedirectView("/product/form");
//        }
//
//        productService.saveWithImage(product, image);
//
//        return new RedirectView("product/products");
//    }

//    @GetMapping("/form")
//    public String addProduct(@RequestParam(value = "id", required = false) Long productId, Model model,
//                             @ModelAttribute(value = "violations") String violations) {
//
//        if (productId != null) {
//            Product product = productService.findById(productId);
//            model.addAttribute("product", product);
//        } else {
//            model.addAttribute("product", new Product());
//        }
//
//        model.addAttribute("categories", categoryService.findAll());
//        //      model.addAttribute("values", new ArrayList<>(Arrays.asList("asd", "asd")));
//        model.addAttribute("violations", violations);
//
//        return "product/form";
//    }
}
