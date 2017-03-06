package com.grade.repository;

import com.grade.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GradeRepository
    extends JpaRepository<Grade, String>, JpaSpecificationExecutor<Grade> {}
