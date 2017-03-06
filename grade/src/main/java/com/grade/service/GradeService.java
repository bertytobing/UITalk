package com.grade.service;

import com.grade.model.entity.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GradeService {

    Grade create(Grade grade);

    void delete(String id);

    Page<Grade> findAll(Pageable pageable);

    Grade update(Grade grade, Grade updatedGrade);
}
