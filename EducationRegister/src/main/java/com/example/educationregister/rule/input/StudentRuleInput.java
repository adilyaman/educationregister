package com.example.educationregister.rule.input;

import com.example.educationregister.enums.ActionType;
import com.example.educationregister.model.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentRuleInput {

    private Student student;

    private ActionType actionType;

}
