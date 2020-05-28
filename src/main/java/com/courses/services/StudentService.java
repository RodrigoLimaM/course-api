package com.courses.services;

import com.courses.entities.Student;
import com.courses.entities.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    Student save(StudentDTO student, Integer courseId);

    StudentDTO findById(Integer id);

    Student deleteById(Integer id);

    Student update(StudentDTO newStudent, Integer id);

    List<StudentDTO> getStudents();
}
