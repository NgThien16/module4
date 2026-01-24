package org.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("student", "sinh viên");
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String result = dictionary.get(word.toLowerCase());

        if (result != null) {
            model.addAttribute("meaning", result);
        } else {
            model.addAttribute("meaning", "Không tìm thấy từ này!");
        }
        return "index";
    }
}
