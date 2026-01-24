package org.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(
            @RequestParam(value = "condiment", required = false) String[] condiment,
            Model model) {

        if (condiment == null) {
            model.addAttribute("result", "Bạn chưa chọn gia vị nào!");
        } else {
            model.addAttribute("result", condiment);
        }

        return "result";
    }
}
