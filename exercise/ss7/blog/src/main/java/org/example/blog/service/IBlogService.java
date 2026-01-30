package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog>  findAll();
    Page<Blog> findAll(String searchTitle, Pageable pageable);

    List<Blog> findByTitle(String title);
    Blog  findById(Integer id);
    boolean update(Blog blog);
    boolean deleteById(Integer id);
    boolean add(Blog blog);
}
