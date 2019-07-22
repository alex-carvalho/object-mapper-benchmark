package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import com.ac.benchmark.model.factory.PersonFactory;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public abstract class PersonMapper {

    public abstract PersonDTO map(Person source);

    @Benchmark
    public PersonDTO benchmark() {
        return map(PersonFactory.createOne());
    }
}