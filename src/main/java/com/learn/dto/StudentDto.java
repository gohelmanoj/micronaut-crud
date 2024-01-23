package com.learn.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
public class StudentDto {

    private Integer rollNumber;
    private String name;
    private Double totalPercentage;
    private String standard;
}
