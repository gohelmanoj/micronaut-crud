package com.learn.repository;

import com.learn.model.Student;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
