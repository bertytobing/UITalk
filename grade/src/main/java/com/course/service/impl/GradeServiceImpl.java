package com.course.service.impl;

import com.course.model.entity.Grade;
import com.course.repository.GradeRepository;
import com.course.service.GradeService;
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

    @Override
    public Grade create(Grade grade) {
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
        updatedGrade.setId(grade.getId());
        BeanUtils.copyProperties(updatedGrade, grade);
        return repository.saveAndFlush(grade);
    }
}
