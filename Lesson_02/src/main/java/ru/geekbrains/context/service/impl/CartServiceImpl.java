package ru.geekbrains.context.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.domain.Product;
import ru.geekbrains.context.repository.ProductRepository;
import ru.geekbrains.context.service.CartService;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Scope(scopeName = "prototype")
public class CartServiceImpl implements CartService {

    ProductRepository productRepository;
    List<Product> productCart;

    @Autowired
    public CartServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    private void init() {
        productCart = new ArrayList<>();
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }


    public List<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(List<Product> productCart) {
        this.productCart = productCart;
    }

    @Override
    public void addProductInCart(int id) {
        Product p = productRepository.getProductNameById(id);
        if (p == null) {
            throw new NoSuchElementException("Продукт с таким ID не найден ..");
        }
        productCart.add(p);
    }

    @Override
    public void deleteProductInCart(int id) {
        Product p = productRepository.getProductNameById(id);
        if (p == null) {
            throw new NoSuchElementException("Продукт с таким ID не найден ..");
        }
        productCart.remove(p);
    }

    @Override
    public void showProductInCart() {
        for (Product p : productCart) {
            System.out.println(p);
        }
    }
}
