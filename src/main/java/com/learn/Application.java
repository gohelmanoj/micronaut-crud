package com.learn;

import io.micronaut.context.annotation.Factory;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Singleton;
import org.modelmapper.ModelMapper;

@Factory
public class Application {

    @Singleton
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
