package com.student.controller;

import com.student.model.entity.Student;
import com.student.service.StudentService;
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
@RequestMapping(value = "/students", produces = { MediaType.APPLICATION_JSON_VALUE })
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        return studentService.create(student);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody String id) {
        studentService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Student> findAll(Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student findById(@PathVariable("id") Student student) {
        return student;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable("id") Student student,
        @Valid @RequestBody Student updatedStudent) {
        return studentService.update(student, updatedStudent);
    }
}