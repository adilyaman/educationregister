package com.example.educationregister.service;

import com.example.educationregister.entity.StudentEntity;
import com.example.educationregister.enums.ActionType;
import com.example.educationregister.mapper.StudentMapper;
import com.example.educationregister.model.Course;
import com.example.educationregister.model.Student;
import com.example.educationregister.repository.StudentRepository;
import com.example.educationregister.rule.StudentRule;
import com.example.educationregister.rule.input.StudentRuleInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentRule studentRule;

    public Student saveNewStudent(Student student) {

        final StudentRuleInput ruleInput = StudentRuleInput.builder().student(student).actionType(ActionType.ADD).build();
        studentRule.apply(ruleInput);

        final StudentEntity studentEntity = StudentMapper.INSTANCE.mapToStudentEntity(student);
        final StudentEntity savedStudent = studentRepository.save(studentEntity);

        return StudentMapper.INSTANCE.mapToStudent(savedStudent);
    }

    public List<Course> getStudentCourses(Long studentId) {

        final StudentEntity studentEntity = getStudentEntityById(studentId);
        final Student student = StudentMapper.INSTANCE.mapToStudent(studentEntity);

        return student.getCourseList();
    }

    public void updateStudent(Student updatedStudent) {

        final StudentEntity currentStudentEntity = getStudentEntityById(updatedStudent.getId());
        final StudentEntity updatedStudentEntity = prepareUpdatedStudentEntity(currentStudentEntity, updatedStudent);

        studentRepository.save(updatedStudentEntity);
    }

    private StudentEntity getStudentEntityById(Long studentId) {

        final Optional<StudentEntity> studentOpt = studentRepository.findStudentEntityById(studentId);
        if (!studentOpt.isPresent()) {
            // TODO hata mesajı
        }

        return studentOpt.get();
    }

    public Student getStudentById(Long studentId) {

        final StudentEntity studentEntity = getStudentEntityById(studentId);
        return StudentMapper.INSTANCE.mapToStudent(studentEntity);
    }

    private StudentEntity prepareUpdatedStudentEntity(StudentEntity currentStudentEntity, Student updatedStudent) {

        final StudentEntity updatedStudentEntity = StudentMapper.INSTANCE.mapToStudentEntity(updatedStudent);
        updatedStudentEntity.setId(currentStudentEntity.getId());

        return updatedStudentEntity;
    }

    public List<Student> getAllStudents() {

        final Optional<List<StudentEntity>> studentEntityListOpt = studentRepository.findAll();
        if (!studentEntityListOpt.isPresent()) {
            return Collections.emptyList();
        }

        return StudentMapper.INSTANCE.mapToStudentList(studentEntityListOpt.get());
    }

}
