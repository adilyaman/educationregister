package com.example.educationregister.rule.input;

import com.example.educationregister.enums.AddDropType;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseRegisterRuleInput {

    private Student student;

    private Course course;

    private AddDropType addDropType;
}
