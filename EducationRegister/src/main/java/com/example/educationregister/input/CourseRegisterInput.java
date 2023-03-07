package com.example.educationregister.input;

import com.example.educationregister.enums.AddDropType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRegisterInput {

    private Long studentId;

    private Long courseId;

    private AddDropType addDropType;

}
