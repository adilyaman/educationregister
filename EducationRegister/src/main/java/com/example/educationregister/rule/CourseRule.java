package com.example.educationregister.rule;

import com.example.educationregister.model.Course;
import com.example.educationregister.rule.input.CourseRuleInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseRule implements BusinessRule<CourseRuleInput> {

    @Override
    public void apply(CourseRuleInput ruleInput) {

        // some rules
    }
}
