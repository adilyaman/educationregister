package com.example.educationregister.rule.input;

import com.example.educationregister.enums.ActionType;
import com.example.educationregister.model.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseRuleInput {

    private Course course;

    private ActionType actionType;

}
