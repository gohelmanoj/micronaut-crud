package com.learn.service.impl;

import com.learn.dto.StudentDto;
import com.learn.exception.StudentNotFoundException;
import com.learn.model.Student;
import com.learn.repository.StudentRepository;
import com.learn.service.StudentServices;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Singleton
public class StudentServiceImpl implements StudentServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private ModelMapper modelMapper;

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
        //return allStudents.stream().map(this::modelToDto).toList();
    }

    @Override
    public StudentDto getStudentByRollNumber(Integer rollNumber) {

        Optional<Student> student = studentRepository.findById(rollNumber);

        if (student.isEmpty()) {
            LOGGER.error(String.format("No Student Exist with %s rollNumber ..!!", rollNumber));
            throw new StudentNotFoundException( rollNumber);
        }
        return modelMapper.map(student.get(), StudentDto.class);
        //return modelToDto(student.get());
    }

    @Override
    public void deleteStudentByRollNumber(Integer rollNumber) {

        Optional<Student> student = studentRepository.findById(rollNumber);
        if (student.isEmpty()) {
            LOGGER.error(String.format("No Student exist with %s rollNumber ..!!", rollNumber));
            throw new StudentNotFoundException(rollNumber);
        }
        studentRepository.deleteById(rollNumber);
    }

    @Override
    public StudentDto updateStudentByRollNumber(Integer rollNumber, StudentDto studentDto) {

        Optional<Student> optionalStudent = studentRepository.findById(rollNumber);

        if (optionalStudent.isEmpty()) {
            LOGGER.error(String.format("No Student Exist with %s rollNumber ..!!", rollNumber));
            throw new StudentNotFoundException(rollNumber);
        }

        Student student = optionalStudent.get();
        student.setName(studentDto.getName());
        student.setStandard(studentDto.getStandard());
        student.setTotalPercentage(studentDto.getTotalPercentage());
        student = studentRepository.update(student);

        //return modelToDto(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        LOGGER.info("Student Request Data " + studentDto.toString());
        Student student = modelMapper.map(studentDto, Student.class);
        //Student student = dtoToModel(studentDto);
        student = studentRepository.save(student);
        //return modelToDto(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto modelToDto(Student student) {

        return new StudentDto(
                student.getRollNumber(),
                student.getName(),
                student.getTotalPercentage(),
                student.getStandard()
        );
    }

    @Override
    public Student dtoToModel(StudentDto studentDto) {
        return new Student(
                studentDto.getRollNumber(),
                studentDto.getName(),
                studentDto.getTotalPercentage(),
                studentDto.getStandard()
        );
    }
}
