package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonModelMapper extends PersonMapper {

    private final org.modelmapper.ModelMapper modelMapper;

    public PersonModelMapper() {
        Converter<LocalDate, String> toStringDate = new AbstractConverter<LocalDate, String>() {
            @Override
            protected String convert(LocalDate source) {
                return source != null ? source.format(DateTimeFormatter.ISO_DATE) : null;
            }
        };

        modelMapper = new org.modelmapper.ModelMapper();
        modelMapper.addConverter(toStringDate);
    }

    @Override
    public PersonDTO map(Person source) {
        return modelMapper.map(source, PersonDTO.class);
    }
}
