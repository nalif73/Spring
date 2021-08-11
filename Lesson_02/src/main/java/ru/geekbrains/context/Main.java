package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.context.configuration.ApplicationConfiguration;
import ru.geekbrains.context.service.CartService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CartService cart = context.getBean("cartServiceImpl", CartService.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Добавить товар в корзину - /add, удалить товар из корзины - /delete, показать корзину - /show");
        while (true) {
            String str = br.readLine();
            if (str.equals("/add")) {
                System.out.println("Введите ID товара");
                int id = Integer.parseInt(br.readLine());
                cart.addProductInCart(id);
            }
            if (str.equals("/delete")) {
                System.out.println("Введите ID товара");
                int id = Integer.parseInt(br.readLine());
                cart.deleteProductInCart(id);
            }
            if (str.equals("/show")) {
                cart.showProductInCart();
            }

        }
    }

}
