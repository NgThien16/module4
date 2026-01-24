package org.example.convertmoney;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {

    @GetMapping("/convert")
    public String convert(
            @RequestParam("amount") double amount,
            Model model) {

        double result = amount * 25000; // ví dụ tỉ giá
        model.addAttribute("result", result);

        return "convert";
    }
}
