package ru.geekbrains.context.repository;

import ru.geekbrains.context.domain.Product;
import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();
    Product getProductNameById(int id);
}
