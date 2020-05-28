package com.courses.controllers;

import com.courses.entities.Student;
import com.courses.entities.dto.StudentDTO;
import com.courses.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> findStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @PostMapping(value = "/{courseId}")
    public ResponseEntity<Student> saveStudent(
            @Valid @RequestBody StudentDTO dto,
            @PathVariable Integer courseId) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/students/" +courseId +"/" +dto.getId()))
                .body(studentService.save(dto, courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        return ResponseEntity.ok().body(studentService.deleteById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @Valid @RequestBody StudentDTO dto,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok().body(studentService.update(dto, id));
    }
}
