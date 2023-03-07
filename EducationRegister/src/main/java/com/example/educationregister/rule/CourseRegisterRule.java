package com.example.educationregister.rule;

import com.example.educationregister.model.Course;
import com.example.educationregister.rule.input.CourseRegisterRuleInput;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CourseRegisterRule implements BusinessRule<CourseRegisterRuleInput> {

    @Override
    public void apply(CourseRegisterRuleInput courseRegisterRuleInput) {

        switch (courseRegisterRuleInput.getAddDropType()) {
            case ADD:
                addCourseValidation(courseRegisterRuleInput);
                break;
            case DROP:
                dropCourseValidation(courseRegisterRuleInput);
                break;
        }

    }

    private void dropCourseValidation(CourseRegisterRuleInput courseRegisterRuleInput) {

        // some rules
    }

    private void addCourseValidation(CourseRegisterRuleInput courseRegisterRuleInput) {

        final Course course = courseRegisterRuleInput.getCourse();
        final int numberOfStudents = course.getStudentList().size();

        if (course.getCapacity().compareTo(numberOfStudents) == BigInteger.ZERO.intValue()) {
            // TODO hata mesajı
        }
    }
}
