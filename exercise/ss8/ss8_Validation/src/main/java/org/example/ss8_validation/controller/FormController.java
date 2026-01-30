package org.example.ss8_validation.controller;

import jakarta.validation.Valid;
import org.example.ss8_validation.entity.User;
import org.example.ss8_validation.service.IUserService;
import org.example.ss8_validation.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserValidate userValidate;

    // Hiển thị form nhập User
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    // Xử lý submit form
    @PostMapping("/register")
    public String save(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        // Custom validate (giống StudentController)
        userValidate.validate(user, bindingResult);

        // Nếu có lỗi → quay lại form
        if (bindingResult.hasErrors()) {
            return "index";
        }

        // Lưu DB
        userService.save(user);

        redirectAttributes.addFlashAttribute("msg", "Đăng ký thành công 🎉");
        return "redirect:/result";
    }

    // Trang kết quả
    @GetMapping("/result")
    public String result() {
        return "result";
    }
}
