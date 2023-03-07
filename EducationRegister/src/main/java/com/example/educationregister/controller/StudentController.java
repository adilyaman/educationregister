package com.example.educationregister.controller;

import com.example.educationregister.RestResponse;
import com.example.educationregister.output.CourseOutput;
import com.example.educationregister.input.SaveStudentInput;
import com.example.educationregister.output.StudentOutput;
import com.example.educationregister.input.UpdateStudentInput;
import com.example.educationregister.mapper.CourseMapper;
import com.example.educationregister.mapper.StudentMapper;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import com.example.educationregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<RestResponse<StudentOutput>> saveNewStudent(SaveStudentInput saveStudentInput) {

        final Student student = StudentMapper.INSTANCE.mapToStudent(saveStudentInput);
        final Student result = studentService.saveNewStudent(student);
        final StudentOutput studentOutput = StudentMapper.INSTANCE.maptoUpdateStudentOutput(result);

        return ResponseEntity.ok(RestResponse.of(studentOutput));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<RestResponse<List<CourseOutput>>> getStudentCourses(@PathVariable("id") Long studentId) {

        final List<Course> courseList = studentService.getStudentCourses(studentId);
        final List<CourseOutput> courseOutputList = CourseMapper.INSTANCE.mapToCourseOutputList(courseList);

        return ResponseEntity.ok(RestResponse.of(courseOutputList));
    }

    @PostMapping("/update")
    public ResponseEntity<RestResponse<Void>> updateStudent(@Validated UpdateStudentInput updateStudentInput) {

        final Student student = StudentMapper.INSTANCE.mapToStudent(updateStudentInput);
        studentService.updateStudent(student);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<StudentOutput>>> getAllStudents() {

        final List<Student> studentList = studentService.getAllStudents();
        final List<StudentOutput> studentOutputList = StudentMapper.INSTANCE.mapToStudentOutputList(studentList);

        return ResponseEntity.ok(RestResponse.of(studentOutputList));
    }

}
