package com.course.service;

import com.course.model.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Course create(Course course);

    void delete(String id);

    Page<Course> findAll(Pageable pageable);

    Course update(Course course, Course updatedCourse);
}
