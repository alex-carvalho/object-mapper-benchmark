package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;

import java.time.format.DateTimeFormatter;

public class PersonManualMapper extends PersonMapper {

    @Override
    public PersonDTO map(Person source) {
        return new PersonDTO(source.getName(), source.getAge(), source.getBirthDate().format(DateTimeFormatter.ISO_DATE));
    }
}
