package com.courses.entities.mapper;

import com.courses.entities.Student;
import com.courses.entities.dto.StudentDTO;
import com.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    CourseService courseService;

    public Student mapStudentDTOToStudent(StudentDTO dto, Integer courseId) {
        return new Student(dto.getName(), courseService.findById(courseId));
    }
}
