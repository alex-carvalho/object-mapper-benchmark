package com.ac.benchmark.model.factory;

import com.ac.benchmark.model.entity.Person;

import java.time.LocalDate;

public class PersonFactory {

    private PersonFactory() {
    }

    public static Person createOne() {
        return new Person("Alex Carvalho", 20, LocalDate.now());
    }
}
