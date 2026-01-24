package org.example.thymeleaf.controller;

import org.example.thymeleaf.entity.Student;
import org.example.thymeleaf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.Subject;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController{
    @ModelAttribute("subjects")
    public List<String> getSubject() {
        return List.of("JS","Java","PHP","C#");
    }
    @Autowired
    private IStudentService studentService;

    @GetMapping(value="")
    public String showList(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping(value="/add")
    public String showAdd(Model model){
        model.addAttribute("student",new Student());
        return "student/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Student student,
                       RedirectAttributes redirectAttributes){
        studentService.add(student);
        redirectAttributes.addFlashAttribute("mess","Add Successfully");
        return "redirect:/students";
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(name="id") int detailID){
        ModelAndView mav = new ModelAndView("student/detail");
        Student student = studentService.findById(detailID);
        mav.addObject("student",student);
        return mav;
    }
    @GetMapping("/{id}/detail")
    public ModelAndView detail1(@PathVariable(name = "id") int detailId){
        ModelAndView modelAndView = new ModelAndView("student/detail");
        Student student = studentService.findById(detailId);
        modelAndView.addObject("student",student);
        return modelAndView;
    }
}
