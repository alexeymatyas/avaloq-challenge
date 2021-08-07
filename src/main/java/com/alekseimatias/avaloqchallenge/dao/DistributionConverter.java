package com.alekseimatias.avaloqchallenge.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

public class DistributionConverter implements AttributeConverter<Map<Integer, Long>, String> {
    @Override
    public String convertToDatabaseColumn(Map<Integer, Long> attribute) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    @Override
    public Map<Integer, Long> convertToEntityAttribute(String dbData) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<Integer, Long>> typeReference = new TypeReference<>() {};
        try {
            return objectMapper.readValue(dbData, typeReference);
        } catch (JsonProcessingException e) {
            return new HashMap<>();
        }
    }
}
