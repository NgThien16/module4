package org.example.demo_module4.service;

import org.example.demo_module4.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();
    static{
        studentList.add(new Student(1,"Thien"));
        studentList.add(new Student(2,"Khanh"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
