package org.example.thymeleaf_product.controller;

import org.example.thymeleaf_product.entity.Product;
import org.example.thymeleaf_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    /* ================== HIỂN THỊ DANH SÁCH ================== */
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }

    /* ================== FORM TẠO MỚI ================== */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    /* ================== FORM CẬP NHẬT ================== */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    /* ================== XOÁ ================== */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.remove(id);
        return "redirect:/products";
    }

    /* ================== XEM CHI TIẾT ================== */
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

    /* ================== TÌM KIẾM ================== */
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.searchByName(name));
        return "product/list";
    }
}
