package com.courses.services.impl;

import com.courses.entities.Course;
import com.courses.repositories.CourseRepository;
import com.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course course) {
        course.setId(null);
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> findByName(String name) {
        return courseRepository.findCourseByNameContainingIgnoreCase(name);
    }

    @Override
    public Course update(Course course) {
        Course actual = this.findById(course.getId());
        actual.setName(course.getName());
        actual.setArea(course.getArea());
        actual.setCourseValue(course.getCourseValue());

        return courseRepository.save(actual);
    }

    @Override
    public Course deleteById(Integer id) {
        Course deletedCourse = courseRepository.findById(id).orElse(null);
        courseRepository.deleteById(id);
        return deletedCourse;
    }
}
