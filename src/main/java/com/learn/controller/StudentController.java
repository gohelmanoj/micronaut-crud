package com.learn.controller;

import com.learn.dto.StudentDto;
import com.learn.service.StudentServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller(value = "/student")
@AllArgsConstructor
public class StudentController {

    private StudentServices studentServices;

    @Get("/{rollNumber}")
    public HttpResponse<StudentDto> getStudentByRollNumber(@PathVariable Integer rollNumber) {

        return HttpResponse.ok(studentServices.getStudentByRollNumber(rollNumber));
    }

    @Get
    public HttpResponse<List<StudentDto>> getAllStudents() {

        return HttpResponse.ok(studentServices.getAllStudents());
    }

    @Delete("/{rollNumber}")
    public HttpResponse<String> deleteStudentByRollNumber(@PathVariable Integer rollNumber) {

        studentServices.deleteStudentByRollNumber(rollNumber);
        return HttpResponse.ok(String.format("Student Deleted Successfully with roll number -> %s", rollNumber));
    }

    @Post
    public HttpResponse<StudentDto> addStudent(@Body StudentDto studentDto) {

        studentDto = studentServices.createStudent(studentDto);
        return HttpResponse.ok(studentDto);
    }

    @Put("/{rollNumber}")
    public HttpResponse<StudentDto> updateStudent(@PathVariable Integer rollNumber, @Body StudentDto studentDto) {

        studentDto = studentServices.updateStudentByRollNumber(rollNumber, studentDto);
        return HttpResponse.ok(studentDto);
    }
}
