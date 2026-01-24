package org.example.thymeleaf_product.repository;

import jakarta.persistence.TypedQuery;
import org.example.thymeleaf_product.entity.Product;
import org.example.thymeleaf_product.util.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query =
                session.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        return session.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Product oldProduct = session.find(Product.class, id);
            if (oldProduct != null) {
                oldProduct.setName(product.getName());
                oldProduct.setPrice(product.getPrice());
                oldProduct.setDescription(product.getDescription());
                // thêm field nào thì set tiếp ở đây

                session.update(oldProduct);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Product product = session.find(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query =
                session.createQuery(
                        "from Product p where p.name like :name",
                        Product.class
                );
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
