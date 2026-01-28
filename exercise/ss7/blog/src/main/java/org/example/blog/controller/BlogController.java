package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.BlogService;
import org.example.blog.service.IBlogService;
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
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    // show list blog
    @GetMapping(value="")
    public String showList(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogList",blogs);
        return "blog/list";
    }
    @GetMapping(value="/add")
    public String showAdd(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("mess","add successfully");
        return "redirect:/blog";
    }
    @GetMapping(value="/detail")
    public String showDetail(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogList",blogs);
        return "blog/detail";
    }
}
