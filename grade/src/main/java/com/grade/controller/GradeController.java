package com.grade.controller;

import com.grade.model.entity.Grade;
import com.grade.service.GradeService;
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
@RequestMapping(value = "/grades", produces = { MediaType.APPLICATION_JSON_VALUE })
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Grade create(@Valid @RequestBody Grade grade) {
        return gradeService.create(grade);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody String id) {
        gradeService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Grade> findAll(Pageable pageable) {
        return gradeService.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Grade update(@PathVariable("id") Grade grade, @Valid @RequestBody Grade updatedGrade) {
        return gradeService.update(grade, updatedGrade);
    }
}