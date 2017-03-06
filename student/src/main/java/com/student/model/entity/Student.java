package com.student.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Getter
@Setter
@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = { "nik" }))
public class Student {

    @Id
    @Column(columnDefinition = "char(36)", nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @NotEmpty
    private String id;

    @Column(nullable = false)
    @Length(max = 255)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @Length(max = 255)
    @NotEmpty
    private String nik;
}
