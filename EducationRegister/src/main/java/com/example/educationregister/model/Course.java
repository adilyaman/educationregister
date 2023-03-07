package com.example.educationregister.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Course {

    private Long id;

    private String code;

    private String name;

    private Integer capacity;

    private List<Student> studentList = new ArrayList();

}
