package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }
}
