package com.grade.service;

import com.grade.model.entity.Course;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("course")
public interface CourseService {

    @RequestMapping(value = { "/courses/{id}" }, method = { RequestMethod.GET })
    Course findById(@PathVariable("id") String id);
}
