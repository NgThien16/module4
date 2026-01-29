package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category  findById(Integer id);
    boolean update(Category category);
    boolean deleteById(Integer id);
    boolean add(Category category);
}
