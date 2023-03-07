package com.example.educationregister.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCourseInput {

    private Long id;

    private String code;

    private String name;

    private Integer capacity;
}
