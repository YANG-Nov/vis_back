package com.dicadut.soms.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-02-17 13:34:15
 */
@Slf4j
public class StakeNumberSerializer extends JsonSerializer<String> {
    /**
     * 把java对象转换成json 返回给前端
     * Method that can be called to ask implementation to serialize
     * values of type this serializer handles.
     *
     * @param value       Value to serialize; can <b>not</b> be null.
     * @param gen         Generator used to output resulting Json content
     * @param serializers Provider that can be used to get serializers for
     */
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String result = value;
        if (value != null && !"".equals(value.trim())) {
            result = value.substring(0, 1) + Integer.parseInt(value.substring(1));
        }
        gen.writeString(result);
        log.info("serialize stake number: {} -->> {}", value, result);
    }
}
