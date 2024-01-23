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
@Requires(classes = {StudentFoundException.class, ExceptionHandler.class})
public class StudentFoundExceptionHandler implements ExceptionHandler<StudentFoundException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, StudentFoundException exception) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getPath(),
                "STUDENT_FOUND"
        );

        return HttpResponse.badRequest(errorDetails);
    }
}
