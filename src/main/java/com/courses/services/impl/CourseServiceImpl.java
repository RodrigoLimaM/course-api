package com.courses.services.impl;

import com.courses.entities.Course;
import com.courses.entities.dto.CourseDTO;
import com.courses.entities.mapper.CourseMapper;
import com.courses.repositories.CourseRepository;
import com.courses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper mapper;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(CourseDTO dto) {
        dto.setId(null);
        return courseRepository.save(mapper.mapCourseDTOToCourse(dto));
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
    public Course update(CourseDTO dto, Integer id) {
        Course actual = this.findById(id);
        actual.setName(dto.getName());
        actual.setArea(dto.getArea());
        actual.setCourseValue(dto.getCourseValue());

        return courseRepository.save(actual);
    }

    @Override
    public Course deleteById(Integer id) {
        Course deletedCourse = courseRepository.findById(id).orElse(null);
        courseRepository.deleteById(id);
        return deletedCourse;
    }
}
