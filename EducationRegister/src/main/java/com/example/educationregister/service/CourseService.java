package com.example.educationregister.service;

import com.example.educationregister.entity.CourseEntity;
import com.example.educationregister.enums.ActionType;
import com.example.educationregister.mapper.CourseMapper;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import com.example.educationregister.repository.CourseRepository;
import com.example.educationregister.rule.CourseRule;
import com.example.educationregister.rule.input.CourseRuleInput;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CourseRule courseRule;

    public Course saveNewCourse(Course course) {

        final CourseEntity courseEntity = CourseMapper.INSTANCE.mapToCourseEntity(course);
        final CourseEntity savedCourse = courseRepository.save(courseEntity);

        return CourseMapper.INSTANCE.mapToCourse(savedCourse);
    }

    public List<Student> getCourseStudents(String courseCode) {

        final Optional<CourseEntity> courseEntityOpt = courseRepository.findCourseEntityByCode(courseCode);
        if (!courseEntityOpt.isPresent()) {
            // TODO hata mesajı
        }

        final Course course = CourseMapper.INSTANCE.mapToCourse(courseEntityOpt.get());
        return course.getStudentList();
    }

    public void updateCourse(Course course) {

        final CourseRuleInput ruleInput = CourseRuleInput.builder().course(course).actionType(ActionType.UPDATE).build();
        courseRule.apply(ruleInput);

        final Optional<CourseEntity> courseEntityOpt = courseRepository.findCourseEntityById(course.getId());
        final CourseEntity courseEntity = prepareUpdatedCourseEntity(courseEntityOpt, course);
        courseRepository.save(courseEntity);
    }

    private CourseEntity prepareUpdatedCourseEntity(Optional<CourseEntity> courseEntityOpt, Course course) {

        final CourseEntity updatedCourseEntity = CourseMapper.INSTANCE.mapToCourseEntity(course);
        updatedCourseEntity.setId(courseEntityOpt.get().getId());

        return updatedCourseEntity;
    }

    public List<Course> getAllCourses() {

        final Optional<List<CourseEntity>> courseListOpt = courseRepository.findAll();
        if (!courseListOpt.isPresent()) {
            return Collections.emptyList();
        }

        return CourseMapper.INSTANCE.mapToCourseList(courseListOpt.get());
    }

    public Course getCourseById(Long courseId) {

        final Optional<CourseEntity> courseEntityOpt = courseRepository.findCourseEntityById(courseId);
        if (!courseEntityOpt.isPresent()) {
            // Hata mesajı
        }

        return  CourseMapper.INSTANCE.mapToCourse(courseEntityOpt.get());
    }
}
