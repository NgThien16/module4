package org.example.demo_email.controller;

import org.example.demo_email.entity.MailSetting;
import org.example.demo_email.service.IMailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mail")
public class MailSettingController {

    @Autowired
    private IMailSettingService service;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("mailSetting", service.getSetting());
        return "mail/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MailSetting mailSetting, Model model) {
        service.save(mailSetting);
        model.addAttribute("mailSetting", mailSetting);
        model.addAttribute("message", "Update successful!");
        return "mail/form";
    }
}
