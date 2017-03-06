package com.grade.service.impl;

import com.grade.model.entity.Course;
import com.grade.model.entity.Grade;
import com.grade.model.entity.Student;
import com.grade.repository.GradeRepository;
import com.grade.service.CourseService;
import com.grade.service.GradeService;
import com.grade.service.StudentService;
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
        Course course = courseService.findById(grade.getCourseId());
        Student student = studentService.findById(grade.getStudentId());
        if (course == null || student == null) {
            throw new RuntimeException("grade or student is null");
        }
    }
}
