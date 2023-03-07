package com.example.educationregister.mapper;

import com.example.educationregister.entity.CourseEntity;
import com.example.educationregister.input.SaveCourseInput;
import com.example.educationregister.output.CourseOutput;
import com.example.educationregister.input.UpdateCourseInput;
import com.example.educationregister.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseEntity mapToCourseEntity(Course course);

    Course mapToCourse(CourseEntity courseEntity);

    Course mapToCourse(SaveCourseInput saveCourseInput);

    List<Course> mapToCourseList(List<CourseEntity> courseEntityList);

    Course mapToCourse(UpdateCourseInput updateCourseInput);

    CourseOutput mapToCourseOutput(Course course);

    List<CourseOutput> mapToCourseOutputList(List<Course> courseList);
}
