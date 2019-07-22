package com.ac.benchmark;

import com.ac.benchmark.mapper.person.PersonMapper;
import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import com.ac.benchmark.model.factory.PersonFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.reflections.Reflections;

import java.util.stream.Stream;

class PersonMapperTest {

    private static Stream<Arguments> getImplementations() {
        return new Reflections(PersonMapper.class.getPackage().getName())
                .getSubTypesOf(PersonMapper.class)
                .stream()
                .filter(clazz -> !clazz.getName().contains("generated"))
                .map(clazz -> Arguments.of(clazz.getSimpleName(), clazz));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("getImplementations")
    void testImplementations(String name, Class<? extends PersonMapper> clazz) {
        PersonMapper personMapper = newInstance(clazz);

        Person person = PersonFactory.createOne();
        PersonDTO dto = personMapper.map(person);

        Assertions.assertAll(
                () -> Assertions.assertEquals(person.getName(), dto.getName()),
                () -> Assertions.assertEquals(person.getAge(), dto.getAge()),
                () -> Assertions.assertEquals(person.getBirthDate().toString(), dto.getBirthDate())
        );
    }

    private PersonMapper newInstance(Class<? extends PersonMapper> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
