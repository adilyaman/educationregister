package com.example.educationregister.mapper;

import com.example.educationregister.entity.StudentEntity;
import com.example.educationregister.input.SaveStudentInput;
import com.example.educationregister.input.UpdateStudentInput;
import com.example.educationregister.model.Student;
import com.example.educationregister.output.StudentOutput;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T19:11:39+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity mapToStudentEntity(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        return studentEntity;
    }

    @Override
    public Student mapToStudent(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Student student = new Student();

        return student;
    }

    @Override
    public List<Student> mapToStudentList(List<StudentEntity> studentEntityList) {
        if ( studentEntityList == null ) {
            return null;
        }

        List<Student> list = new ArrayList<Student>( studentEntityList.size() );
        for ( StudentEntity studentEntity : studentEntityList ) {
            list.add( mapToStudent( studentEntity ) );
        }

        return list;
    }

    @Override
    public Student mapToStudent(SaveStudentInput saveStudentInput) {
        if ( saveStudentInput == null ) {
            return null;
        }

        Student student = new Student();

        return student;
    }

    @Override
    public Student mapToStudent(UpdateStudentInput updateStudentInput) {
        if ( updateStudentInput == null ) {
            return null;
        }

        Student student = new Student();

        return student;
    }

    @Override
    public StudentOutput maptoUpdateStudentOutput(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentOutput studentOutput = new StudentOutput();

        return studentOutput;
    }

    @Override
    public List<StudentOutput> mapToStudentOutputList(List<Student> studentList) {
        if ( studentList == null ) {
            return null;
        }

        List<StudentOutput> list = new ArrayList<StudentOutput>( studentList.size() );
        for ( Student student : studentList ) {
            list.add( maptoUpdateStudentOutput( student ) );
        }

        return list;
    }
}
