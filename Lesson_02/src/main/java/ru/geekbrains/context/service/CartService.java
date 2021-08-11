package ru.geekbrains.context.service;


public interface CartService {

    public void addProductInCart(int id);
    public void deleteProductInCart(int id);
    public void showProductInCart();
}
