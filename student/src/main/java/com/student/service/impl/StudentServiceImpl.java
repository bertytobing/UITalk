package com.student.service.impl;

import com.student.model.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(Student student) {
        return repository.saveAndFlush(student);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Student update(Student student, Student updatedStudent) {
        updatedStudent.setId(student.getId());
        BeanUtils.copyProperties(updatedStudent, student);
        return repository.saveAndFlush(student);
    }
}
