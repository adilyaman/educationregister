package com.example.educationregister.repository;

import com.example.educationregister.entity.StudentEntity;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends Repository<StudentEntity, Long> {

    StudentEntity save(StudentEntity studentEntity);

    Optional<StudentEntity> findStudentEntityById(Long id);

    Optional<List<StudentEntity>> findAll();

}
