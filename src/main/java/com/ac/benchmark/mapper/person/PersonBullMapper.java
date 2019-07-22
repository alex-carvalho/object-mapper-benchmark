package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import com.hotels.beans.BeanUtils;
import com.hotels.beans.model.FieldTransformer;
import com.hotels.beans.transformer.Transformer;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;

public class PersonBullMapper extends PersonMapper {

    private final Transformer transformer;

    public PersonBullMapper() {
        FieldTransformer<LocalDate, String> dateTransformer = new FieldTransformer<>("birthDate", ISO_DATE::format);

        transformer = new BeanUtils()
                .getTransformer()
                .withFieldTransformer(dateTransformer);
    }

    @Override
    public PersonDTO map(Person source) {
        return transformer.transform(source, PersonDTO.class);
    }
}
