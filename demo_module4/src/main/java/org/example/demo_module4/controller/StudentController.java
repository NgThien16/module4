package org.example.demo_module4.controller;

import org.example.demo_module4.entity.Student;
import org.example.demo_module4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }
}
