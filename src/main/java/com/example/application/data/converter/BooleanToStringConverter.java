package com.example.application.data.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute ? "A" : "I";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "A".equals(dbData) ? true: false;
    }
}
