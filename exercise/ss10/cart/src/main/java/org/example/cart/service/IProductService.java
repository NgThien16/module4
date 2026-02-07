package org.example.cart.service;

import org.example.cart.entity.Product;

import java.util.Optional;

public interface IProductService {
  Iterable<Product> findAll();
  Optional<Product> findById(Integer id);
}
