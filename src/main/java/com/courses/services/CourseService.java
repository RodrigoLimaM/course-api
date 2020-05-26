package com.courses.services;

import com.courses.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course save(Course course);

    public Course findById(Integer id);

    public List<Course> findByName(String name);

    public Course update(Course course);
}
