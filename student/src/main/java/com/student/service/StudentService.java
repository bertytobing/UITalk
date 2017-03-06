package com.student.service;

import com.student.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Student create(Student student);

    void delete(String id);

    Page<Student> findAll(Pageable pageable);

    Student update(Student student, Student updatedStudent);
}
