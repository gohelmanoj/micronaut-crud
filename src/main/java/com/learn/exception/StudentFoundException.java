package com.learn.exception;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;

public class StudentFoundException extends HttpStatusException {

    public StudentFoundException(Integer rollNumber) {

        super(HttpStatus.BAD_REQUEST, String.format("Student already exist with %s rollNumber ..!!", rollNumber));
    }
}
