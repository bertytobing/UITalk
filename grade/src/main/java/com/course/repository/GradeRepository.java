package com.course.repository;

import com.course.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GradeRepository
    extends JpaRepository<Grade, String>, JpaSpecificationExecutor<Grade> {}
