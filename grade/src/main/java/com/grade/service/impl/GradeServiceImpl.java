package com.grade.service.impl;

import com.grade.model.entity.Course;
import com.grade.model.entity.Grade;
import com.grade.model.entity.Student;
import com.grade.repository.GradeRepository;
import com.grade.service.CourseService;
import com.grade.service.GradeService;
import com.grade.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository repository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Override
    public Grade create(Grade grade) {
        assertCourseAndStudentNotNull(grade);
        return repository.saveAndFlush(grade);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Page<Grade> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Grade update(Grade grade, Grade updatedGrade) {
        assertCourseAndStudentNotNull(updatedGrade);
        updatedGrade.setId(grade.getId());
        BeanUtils.copyProperties(updatedGrade, grade);
        return repository.saveAndFlush(grade);
    }

    private void assertCourseAndStudentNotNull(Grade grade) {
        Course course = getCourseById(grade.getCourseId());
        Student student = getStudentById(grade.getStudentId());
        if (course == null || student == null) {
            throw new RuntimeException("grade or student is null");
        }
    }

    private Course courseNotFound(String id) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "courseNotFound")
    public Course getCourseById(String id) {
        return courseService.findById(id);
    }

    @HystrixCommand(fallbackMethod = "studentNotFound")
    public Student getStudentById(String id) {
        return studentService.findById(id);
    }

    private Student studentNotFound(String id) {
        return null;
    }
}
