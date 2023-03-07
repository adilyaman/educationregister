package com.example.educationregister.service;

import com.example.educationregister.entity.CourseEntity;
import com.example.educationregister.entity.StudentEntity;
import com.example.educationregister.input.CourseRegisterInput;
import com.example.educationregister.mapper.CourseMapper;
import com.example.educationregister.mapper.StudentMapper;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import com.example.educationregister.repository.StudentRepository;
import com.example.educationregister.rule.CourseRegisterRule;
import com.example.educationregister.rule.input.CourseRegisterRuleInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseRegisterService {

    private final StudentService studentService;
    private final CourseService courseService;
    private final CourseRegisterRule registerRule;

    private final StudentRepository studentRepository;

    public void addDropCourse(CourseRegisterInput courseRegisterInput) {

        final Student student = studentService.getStudentById(courseRegisterInput.getStudentId());
        final Course course = courseService.getCourseById(courseRegisterInput.getCourseId());

        final CourseRegisterRuleInput courseRegisterRuleInput = CourseRegisterRuleInput.builder()
                .student(student)
                .course(course)
                .addDropType(courseRegisterInput.getAddDropType())
                .build();

        registerRule.apply(courseRegisterRuleInput);

        switch (courseRegisterInput.getAddDropType()) {
            case ADD:
                addCourse(student, course);
                break;
            case DROP:
                dropCourse(student, course);
                break;
        }

    }

    private void dropCourse(Student student, Course course) {

        /*final StudentEntity studentEntity = StudentMapper.INSTANCE.mapToStudentEntity(student);
        final CourseRegisterEntity courseRegisterEntity = studentEntity.getCourseRegisterList().stream()
                .filter(r -> student.getId().equals(r.getStudent().getId()) &&
                        course.getId().equals(r.getCourse().getId())).findFirst().get();

        registerRepository.deleteById(courseRegisterEntity.getId());*/
    }

    private void addCourse(Student student, Course course) {

        final StudentEntity studentEntity = StudentMapper.INSTANCE.mapToStudentEntity(student);
        final CourseEntity courseEntity = CourseMapper.INSTANCE.mapToCourseEntity(course);

        // studentEntity.getCourseList().add(courseEntity);
        studentRepository.save(studentEntity);
    }
}
