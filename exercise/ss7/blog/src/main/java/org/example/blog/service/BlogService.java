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
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Blog blog) {
        if (false) {
            return false;
        }

        if (!blogRepository.existsById(blog.getId())) {
            return false;
        }

        blogRepository.save(blog);
        return true;
    }


    @Override
    public boolean deleteById(Integer id) {
        if (!blogRepository.existsById(id)) {
            return false;
        }
        blogRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean add(Blog blog) {
        return blogRepository.save(blog)!=null;
    }
}
