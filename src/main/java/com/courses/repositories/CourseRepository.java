package com.courses.repositories;

import com.courses.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findCourseByNameContainingIgnoreCase(String name);
}
