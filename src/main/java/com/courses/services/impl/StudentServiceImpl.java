package com.courses.services.impl;

import com.courses.entities.Student;
import com.courses.repositories.StudentRepository;
import com.courses.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }
}
