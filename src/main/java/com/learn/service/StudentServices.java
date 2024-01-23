package com.learn.service;

import com.learn.dto.StudentDto;
import com.learn.model.Student;

import java.util.List;

public interface StudentServices {

    List<StudentDto> getAllStudents();

    StudentDto getStudentByRollNumber(Integer rollNumber);

    void deleteStudentByRollNumber(Integer rollNumber);

    StudentDto updateStudentByRollNumber(Integer rollNumber, StudentDto studentDto);

    StudentDto createStudent(StudentDto studentDto);

    StudentDto modelToDto(Student student);

    Student dtoToModel(StudentDto studentDto);
}
