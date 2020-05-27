package com.courses.services;

import com.courses.entities.Student;
import com.courses.entities.dto.StudentDTO;

public interface StudentService {

    Student save(Student student);

    StudentDTO findById(Integer id);

    Student deleteById(Integer id);
}
