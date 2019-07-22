package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class PersonMapStructMapper extends PersonMapper {

    @Override
    public PersonDTO map(Person source) {
        return StructMapper.INSTANCE.map(source);
    }

    @Mapper
    public interface StructMapper {
        StructMapper INSTANCE = Mappers.getMapper(StructMapper.class);

        @Mapping(target = "birthDate", expression = "java(source.getBirthDate().format(java.time.format.DateTimeFormatter.ISO_DATE))")
        PersonDTO map(Person source);
    }
}
