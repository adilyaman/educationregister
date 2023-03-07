package com.example.educationregister.controller;

import com.example.educationregister.RestResponse;
import com.example.educationregister.input.CourseRegisterInput;
import com.example.educationregister.service.CourseRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course-register")
public class CourseRegisterController {

    private final CourseRegisterService registerService;

    @PostMapping("/add-drop")
    public ResponseEntity<RestResponse<Void>> addDropCourse(@Validated CourseRegisterInput courseRegisterInput){

        registerService.addDropCourse(courseRegisterInput);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
