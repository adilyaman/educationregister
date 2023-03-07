package com.example.educationregister.mapper;

import com.example.educationregister.entity.CourseEntity;
import com.example.educationregister.input.SaveCourseInput;
import com.example.educationregister.input.UpdateCourseInput;
import com.example.educationregister.model.Course;
import com.example.educationregister.output.CourseOutput;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T19:11:39+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseEntity mapToCourseEntity(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();

        return courseEntity;
    }

    @Override
    public Course mapToCourse(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }

    @Override
    public Course mapToCourse(SaveCourseInput saveCourseInput) {
        if ( saveCourseInput == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }

    @Override
    public List<Course> mapToCourseList(List<CourseEntity> courseEntityList) {
        if ( courseEntityList == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( courseEntityList.size() );
        for ( CourseEntity courseEntity : courseEntityList ) {
            list.add( mapToCourse( courseEntity ) );
        }

        return list;
    }

    @Override
    public Course mapToCourse(UpdateCourseInput updateCourseInput) {
        if ( updateCourseInput == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }

    @Override
    public CourseOutput mapToCourseOutput(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseOutput courseOutput = new CourseOutput();

        return courseOutput;
    }

    @Override
    public List<CourseOutput> mapToCourseOutputList(List<Course> courseList) {
        if ( courseList == null ) {
            return null;
        }

        List<CourseOutput> list = new ArrayList<CourseOutput>( courseList.size() );
        for ( Course course : courseList ) {
            list.add( mapToCourseOutput( course ) );
        }

        return list;
    }
}
