package com.geekbrains.ru.springproduct.repository.impl;


import com.geekbrains.ru.springproduct.component.HibernateSessionFactoryManager;
import com.geekbrains.ru.springproduct.domain.Product;
import com.geekbrains.ru.springproduct.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final HibernateSessionFactoryManager factoryManager;

    @Override
    public List<Product> findAll() {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();

            return products;
        }
    }

    @Override
    public Optional<Product> findById(long id) {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            Optional<Product> optional = Optional.ofNullable(session.get(Product.class, id));
            session.getTransaction().commit();

            return optional;
        }
    }

    @Override
    public Product save(Product product) {
        try(Session session = factoryManager.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();

            return product;
        }
    }
}
