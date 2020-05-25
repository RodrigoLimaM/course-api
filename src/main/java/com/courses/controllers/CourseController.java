package com.courses.controllers;

import com.courses.entities.Course;
import com.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController()
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCursos() {
        List<Course> responseList = courseService.getCourses();
        return ResponseEntity
                    .ok()
                    .body(responseList);
    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) throws URISyntaxException {
        Course newCourse = courseService.save(course);
        return ResponseEntity
                    .created(new URI("/cursos/save/" +course.getId()))
                    .body(newCourse);
    }
}
