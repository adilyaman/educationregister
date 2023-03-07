package com.example.educationregister.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "STUDENT")
public class StudentEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 200)
    private String surname;

    @ManyToMany
    @JoinTable(
            name = "course_register",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courseList;

    /*@JsonIgnoreProperties("student")
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<CourseRegisterEntity> courseRegisterList;*/

}
