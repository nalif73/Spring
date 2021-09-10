package com.geekbrains.ru.springproduct.component;

import com.geekbrains.ru.springproduct.domain.Product;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
public class ShopCart {


    private final Map<Product, Integer> productsWithCount = new HashMap<>();

    public void addProduct(Product product) {
        productsWithCount.merge(product, 1, (prev, cur) -> prev + 1);
    }

    public void removeProduct(Product product) {
        if (productsWithCount.containsKey(product)) {
            Integer count = productsWithCount.get(product);

            removeProduct(product, count);

            return;
        }

        throw new IllegalArgumentException("Продукт не найден в корзине");
    }

    private void removeProduct(Product product, Integer count) {
        if (count > 1) {
            productsWithCount.put(product, count - 1);
        } else {
            productsWithCount.remove(product);
        }
    }


    public Map<Product, Integer> getProductsWithCount() {
        return new HashMap<>(productsWithCount);
    }

    public int getCount() {
        return productsWithCount.values().stream()
                .reduce(0, Integer::sum);
    }

}
