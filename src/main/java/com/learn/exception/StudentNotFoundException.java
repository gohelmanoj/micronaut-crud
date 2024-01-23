package com.learn.exception;

import lombok.AllArgsConstructor;

public class StudentNotFoundException extends RuntimeException {

    private Integer rollNumber;

    public StudentNotFoundException(Integer rollNumber) {
        super(String.format("No Student Exist with %s rollNumber ..!!", rollNumber));
    }
}
