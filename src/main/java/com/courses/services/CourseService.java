package com.courses.services;

import com.courses.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course save(Course course);

    Course findById(Integer id);

    List<Course> findByName(String name);

    Course update(Course course);

    Course deleteById(Integer id);
}
