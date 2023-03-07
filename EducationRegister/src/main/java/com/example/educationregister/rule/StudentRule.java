package com.example.educationregister.rule;

import com.example.educationregister.rule.input.StudentRuleInput;
import org.springframework.stereotype.Service;

@Service
public class StudentRule implements BusinessRule<StudentRuleInput> {

    @Override
    public void apply(StudentRuleInput ruleInput) {

        // some rules
    }
}
