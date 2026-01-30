package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.BlogService;
import org.example.blog.service.IBlogService;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    // show list blog
    @GetMapping(value="")
    public String showList(@RequestParam(name="page", defaultValue="0") int page,
                           @RequestParam(name = "searchTitle",defaultValue = "") String searchTitle
                          , Model model){
        Sort sort = Sort.by("publishedDate").descending();
        Pageable pageable = PageRequest.of(page, 4, sort);
        Page<Blog> blogPage = blogService.findAll(searchTitle, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchTitle", searchTitle);
        return "blog/list";
    }
    @GetMapping(value="/add")
    public String showAdd(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("mess","add successfully");
        return "redirect:/blog";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        Blog blog = blogService.findById(id);

        if (blog == null) {
            return "redirect:/blog";
        }

        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@org.springframework.web.bind.annotation.PathVariable Integer id,
                         RedirectAttributes redirectAttributes) {

        boolean result = blogService.deleteById(id);
        if (result) {
            redirectAttributes.addFlashAttribute("mess", "Delete successfully");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Blog not found");
        }
        return "redirect:/blog";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@org.springframework.web.bind.annotation.PathVariable Integer id,
                           Model model,
                           RedirectAttributes redirectAttributes) {

        Blog blog = blogService.findById(id);
        if (blog == null) {
            redirectAttributes.addFlashAttribute("mess", "Blog not found");
            return "redirect:/blog";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.findAll());
        return "blog/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {

        boolean result = blogService.update(blog);
        if (result) {
            redirectAttributes.addFlashAttribute("mess", "Update successfully");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Update failed");
        }
        return "redirect:/blog";
    }



}
