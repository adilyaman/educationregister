package com.example.educationregister.mapper;

import com.example.educationregister.entity.StudentEntity;
import com.example.educationregister.input.SaveStudentInput;
import com.example.educationregister.output.StudentOutput;
import com.example.educationregister.input.UpdateStudentInput;
import com.example.educationregister.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentEntity mapToStudentEntity(Student student);

    Student mapToStudent(StudentEntity studentEntity);

    List<Student> mapToStudentList(List<StudentEntity> studentEntityList);

    Student mapToStudent(SaveStudentInput saveStudentInput);

    Student mapToStudent(UpdateStudentInput updateStudentInput);

    StudentOutput maptoUpdateStudentOutput(Student student);

    List<StudentOutput> mapToStudentOutputList(List<Student> studentList);
}
