package org.geekbrains.ru;

import org.flywaydb.core.Flyway;
import org.geekbrains.ru.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static SessionFactory factory;

    private static void init() {
        factory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void shutdown() {
        factory.close();
    }

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/product-app", "postgres", "postgrespass").load();
        flyway.migrate();
        try {
            init();
            ProductDao productDao = new ProductDao(factory);
            System.out.println(productDao.findById(2L));
            productDao.deleteById(2L);
            System.out.println(productDao.findAll());
            System.out.println(productDao.saveOrUpdate(new Product("Tea", 60)));

        } finally {
            shutdown();
        }
    }

}
