package ru.geekbrains.context.repository.impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.context.domain.Product;
import ru.geekbrains.context.repository.ProductRepository;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductRepositoryImpl(List<Product> productList) {
        Collections.unmodifiableList(productList);
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Яблоко", 7.85));
        productList.add(new Product(2, "Колбаса", 50.76));
        productList.add(new Product(3, "Хлеб", 2.12));
        productList.add(new Product(4, "Йогурт", 32.39));
        productList.add(new Product(5, "Шоколад", 16.98));
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public Product getProductNameById(int id) {
        Product tmp = null;
        for (Product p : productList) {
            if (p.getId() == id) {
                tmp = p;
            }
        }
        return tmp;
    }
}
