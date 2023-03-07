package com.example.educationregister.controller;

import com.example.educationregister.RestResponse;
import com.example.educationregister.input.SaveCourseInput;
import com.example.educationregister.output.CourseOutput;
import com.example.educationregister.output.StudentOutput;
import com.example.educationregister.input.UpdateCourseInput;
import com.example.educationregister.mapper.CourseMapper;
import com.example.educationregister.mapper.StudentMapper;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import com.example.educationregister.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<RestResponse<CourseOutput>> saveNewCourse(@Validated SaveCourseInput saveCourseInput) {

        final Course course = CourseMapper.INSTANCE.mapToCourse(saveCourseInput);
        final Course result = courseService.saveNewCourse(course);
        final CourseOutput courseOutput = CourseMapper.INSTANCE.mapToCourseOutput(result);

        return ResponseEntity.ok(RestResponse.of(courseOutput));
    }

    @GetMapping("/students/{code}")
    public ResponseEntity<RestResponse<List<StudentOutput>>> getCourseStudents(@PathVariable("code") String courseCode) {

        final List<Student> studentList = courseService.getCourseStudents(courseCode);
        final List<StudentOutput> studentOutputList = StudentMapper.INSTANCE.mapToStudentOutputList(studentList);

        return ResponseEntity.ok(RestResponse.of(studentOutputList));
    }

    @PostMapping("/update")
    public ResponseEntity<RestResponse<Void>> updateCourse(@Validated UpdateCourseInput updateCourseInput) {

        final Course course = CourseMapper.INSTANCE.mapToCourse(updateCourseInput);
        courseService.updateCourse(course);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<CourseOutput>>> getAllCourses() {

        final List<Course> courseList = courseService.getAllCourses();
        final List<CourseOutput> courseOutputList = CourseMapper.INSTANCE.mapToCourseOutputList(courseList);

        return ResponseEntity.ok(RestResponse.of(courseOutputList));
    }
}
