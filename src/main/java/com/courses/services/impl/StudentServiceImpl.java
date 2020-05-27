package com.courses.services.impl;

import com.courses.entities.Course;
import com.courses.entities.Student;
import com.courses.entities.dto.CourseDTO;
import com.courses.entities.dto.StudentDTO;
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

    @Override
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        Course course = student.getCourse();
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .courseDTO(new CourseDTO(course.getId(), course.getName(), course.getArea(), course.getCourseValue()))
                .build();
    }

    @Override
    public Student deleteById(Integer id) {
        Student deletedStudent = studentRepository.findById(id).orElse(null);
        studentRepository.deleteById(id);
        return deletedStudent;
    }
}
