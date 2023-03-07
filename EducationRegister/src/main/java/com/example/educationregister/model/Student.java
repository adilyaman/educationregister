package com.example.educationregister.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {

    private Long id;

    private String name;

    private String surname;

    private List<Course> courseList = new ArrayList();
}
