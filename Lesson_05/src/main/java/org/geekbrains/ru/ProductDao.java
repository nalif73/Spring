package org.geekbrains.ru;

import org.geekbrains.ru.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class ProductDao {

    public  static SessionFactory factory;


    public ProductDao(SessionFactory factory) {
        ProductDao.factory =factory;

    }

    public Product findById(Long id) {
        Product product;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    public List<Product> findAll() {
        List<Product> productList;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return productList;
    }

    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
        return product;
    }
}
