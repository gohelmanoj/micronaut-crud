package com.learn.exception;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;

@Produces
@Singleton
@Requires(classes = {StudentNotFoundException.class, ExceptionHandler.class})
public class StudentNotFoundExceptionHandler implements ExceptionHandler<StudentNotFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, StudentNotFoundException exception) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getPath(),
                "STUDENT_NOT_FOUND"
        );

        return HttpResponse.notFound(errorDetails);
    }
}
