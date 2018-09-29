package com.avatech.edi.administrative.model.config;

import com.avatech.edi.administrative.model.dto.OrgResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class ListDeserializer<T> extends JsonDeserializer<List<T>> {

    @Override
    public List<T> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Object value = jsonParser.readValueAs(new TypeReference<List<T>>(){});
        if(value instanceof List){
            return (List<T>)value;
        }else return null;
    }

}
