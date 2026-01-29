package org.example.blog.service;

import org.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog  findById(Integer id);
    boolean update(Blog blog);
    boolean deleteById(Integer id);
    boolean add(Blog blog);
}
