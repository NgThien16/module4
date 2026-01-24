package org.example.thymeleaf.repository;

import org.example.thymeleaf.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    Student findById(int id);
    boolean add(Student student);
}
