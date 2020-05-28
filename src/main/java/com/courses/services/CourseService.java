package com.courses.services;

import com.courses.entities.Course;
import com.courses.entities.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course save(CourseDTO dto);

    Course findById(Integer id);

    List<Course> findByName(String name);

    Course update(CourseDTO dto, Integer id);

    Course deleteById(Integer id);
}
