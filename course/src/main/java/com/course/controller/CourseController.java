package com.course.controller;

import com.course.model.entity.Course;
import com.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/courses", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody Course course) {
        return courseService.create(course);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody String id) {
        courseService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Course> findAll(Pageable pageable) {
        return courseService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course findById(@PathVariable("id") Course course) {
        return course;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable("id") Course course,
        @Valid @RequestBody Course updatedCourse) {
        return courseService.update(course, updatedCourse);
    }
}