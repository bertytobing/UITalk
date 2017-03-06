package com.grade.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @Column(columnDefinition = "char(36)", nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, columnDefinition = "char(36)")
    @NotEmpty
    private String studentId;

    @Column(nullable = false, columnDefinition = "char(36")
    @NotEmpty
    private String courseId;

    @Column(nullable = false)
    @NotNull
    private Integer grade;
}
