package com.courses.controllers;

import com.courses.entities.Course;
import com.courses.entities.dto.CourseDTO;
import com.courses.services.CourseService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok().body(courseService.getCourses());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> findCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(courseService.findById(id));
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> findCourseByName(@RequestParam String name) {
        return ResponseEntity.ok().body(courseService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(
            @Valid @RequestBody CourseDTO dto) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/courses/" +dto.getId()))
                .body(courseService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @Valid @RequestBody CourseDTO dto,
            @PathVariable Integer id) throws URISyntaxException {
        return ResponseEntity.ok().body(courseService.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Integer id) {
        return ResponseEntity.ok().body(courseService.deleteById(id));
    }
}
