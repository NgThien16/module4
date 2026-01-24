package org.example.thymeleaf.service;

import org.example.thymeleaf.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
}
