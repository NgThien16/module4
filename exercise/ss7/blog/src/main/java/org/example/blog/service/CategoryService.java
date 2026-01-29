package org.example.blog.service;

import org.example.blog.entity.Category;
import org.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Category category) {
        if (false) {
            return false;
        }

        categoryRepository.save(category);
        return true;
    }


    @Override
    public boolean deleteById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean add(Category category) {
        return categoryRepository.save(category)!=null;
    }
}
