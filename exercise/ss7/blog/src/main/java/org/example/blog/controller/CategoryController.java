package org.example.blog.controller;

import org.example.blog.entity.Blog;
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
        return "category/list";
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
    @GetMapping("/delete/{id}")
    public String delete(@org.springframework.web.bind.annotation.PathVariable Integer id,
                         RedirectAttributes redirectAttributes) {

        boolean result = categoryService.deleteById(id);
        if (result) {
            redirectAttributes.addFlashAttribute("mess", "Delete successfully");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Category not found");
        }
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@org.springframework.web.bind.annotation.PathVariable Integer id,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        Category category = categoryService.findById(id);
        if (category == null) {
            redirectAttributes.addFlashAttribute("mess", "Category not found");
            return "redirect:/category";
        }
        model.addAttribute("category", category);
        return "category/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Category category,
                         RedirectAttributes redirectAttributes) {

        boolean result = categoryService.update(category);
        if (result) {
            redirectAttributes.addFlashAttribute("mess", "Update successfully");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Update failed");
        }
        return "redirect:/category";
    }
}
