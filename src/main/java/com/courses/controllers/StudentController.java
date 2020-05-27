package com.courses.controllers;

import com.courses.entities.Course;
import com.courses.entities.Student;
import com.courses.entities.dto.CourseDTO;
import com.courses.entities.dto.StudentDTO;
import com.courses.entities.mapper.StudentMapper;
import com.courses.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper mapper;

    @PostMapping(value = "/{courseId}")
    public ResponseEntity<Student> saveStudent(
            @Valid @RequestBody StudentDTO dto,
            @PathVariable Integer courseId) throws URISyntaxException {
        Student newStudent = studentService.save(mapper.mapStudentDTOToStudent(dto, courseId));
        return ResponseEntity
                .created(new URI("/students/" +courseId +"/" +dto.getId()))
                .body(newStudent);
    }
}
