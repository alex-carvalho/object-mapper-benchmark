package com.ac.benchmark.mapper.person;

import com.ac.benchmark.model.dto.PersonDTO;
import com.ac.benchmark.model.entity.Person;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonJacksonMapper extends PersonMapper {

    private final ObjectMapper objectMapper;

    public PersonJacksonMapper() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
    }

    @Override
    public PersonDTO map(Person source) {
        return objectMapper.convertValue(source, PersonDTO.class);
    }

    private static class LocalDateSerializer extends JsonSerializer<LocalDate> {

        @Override
        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (value == null) {
                gen.writeNull();
            } else {
                gen.writeString(value.format(DateTimeFormatter.ISO_DATE));
            }
        }
    }

    private static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String dateAsString = p.getText();
            if (dateAsString == null || dateAsString.isEmpty()) {
                return null;
            } else {
                return LocalDate.parse(dateAsString, DateTimeFormatter.ISO_DATE);
            }
        }
    }
}
