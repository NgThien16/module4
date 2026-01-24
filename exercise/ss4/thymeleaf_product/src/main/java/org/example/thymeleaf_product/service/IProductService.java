package org.example.thymeleaf_product.service;

import org.example.thymeleaf.entity.Student;
import org.example.thymeleaf_product.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
    List<Product> searchByName(String name);
}
