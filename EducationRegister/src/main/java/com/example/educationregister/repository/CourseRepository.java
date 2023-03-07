package com.example.educationregister.repository;


import com.example.educationregister.entity.CourseEntity;
import com.example.educationregister.entity.StudentEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends Repository<CourseEntity, Long> {

    CourseEntity save(CourseEntity courseEntity);

    Optional<CourseEntity> findCourseEntityByCode(String code);

    Optional<CourseEntity> findCourseEntityById(Long id);

    Optional<List<CourseEntity>> findAll();
}
