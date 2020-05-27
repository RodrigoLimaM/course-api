package com.courses.entities.mapper;

import com.courses.entities.Course;
import com.courses.entities.dto.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course mapCourseDTOToCourse(CourseDTO dto) {
        return new Course(dto.getName(), dto.getArea(), dto.getCourseValue());
    }
}
