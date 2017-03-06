package com.grade.service;

import com.grade.model.entity.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("student")
public interface StudentService {

    @RequestMapping(value = { "/students/{id}" }, method = { RequestMethod.GET })
    Student findById(@PathVariable("id") String id);
}
