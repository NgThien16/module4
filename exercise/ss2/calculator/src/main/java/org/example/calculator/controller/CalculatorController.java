package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("number1") double number1,
            @RequestParam("number2") double number2,
            @RequestParam("operator") String operator,
            Model model) {

        double result = 0;
        String message = "";

        switch (operator) {
            case "add":
                result = number1 + number2;
                message = "Result Addition : ";
                break;
            case "sub":
                result = number1 - number2;
                message = "Result Subtraction : ";
                break;
            case "mul":
                result = number1 * number2;
                message = "Result Multiplication : ";
                break;
            case "div":
                if (number2 == 0) {
                    model.addAttribute("error", "Không thể chia cho 0");
                    return "index";
                }
                result = number1 / number2;
                message = "Result Division : ";
                break;
        }

        model.addAttribute("message", message);
        model.addAttribute("result", result);
        return "index";
    }
}
