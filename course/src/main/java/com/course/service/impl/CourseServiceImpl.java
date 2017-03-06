package com.course.service.impl;

import com.course.model.entity.Course;
import com.course.repository.CourseRepository;
import com.course.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public Course create(Course course) {
        return repository.saveAndFlush(course);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Course update(Course course, Course updatedCourse) {
        updatedCourse.setId(course.getId());
        BeanUtils.copyProperties(updatedCourse, course);
        return repository.saveAndFlush(course);
    }
}
