package org.example.blog.controller;

import org.example.blog.entity.Category;
import org.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(value="")
    public String category(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categoryList",categories);
        return "category";
    }
    @GetMapping(value="/add")
    public String showAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category,
                              RedirectAttributes redirectAttributes) {
        categoryService.add(category);
        redirectAttributes.addFlashAttribute("mess", "add Category success");
        return "redirect:/category";
    }
}
