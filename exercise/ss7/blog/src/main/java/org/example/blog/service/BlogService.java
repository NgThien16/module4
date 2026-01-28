package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean update(Blog blog) {
        return false;
    }

    @Override
    public void deleteById(Integer id) {
         blogRepository.deleteById(id);
    }

    @Override
    public boolean add(Blog blog) {
        return blogRepository.save(blog)!=null;
    }
}
