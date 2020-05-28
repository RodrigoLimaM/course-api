package com.courses.entities.mapper;

import com.courses.entities.Course;
import com.courses.entities.Student;
import com.courses.entities.dto.CourseDTO;
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

    public StudentDTO mapStudentToStudentDTO(Student student) {
        return buildStudentDTO(student);
    }

    private StudentDTO buildStudentDTO(Student student) {
        Course course = student.getCourse();
        return StudentDTO
                .builder()
                .id(student.getId())
                .name(student.getName()).
                courseDTO(CourseDTO
                        .builder()
                        .id(course.getId())
                        .name(course.getName())
                        .area(course.getArea())
                        .courseValue(course.getCourseValue())
                        .build())
                .registrationDate(student.getRegistrationDate())
                .build();
    }
}
