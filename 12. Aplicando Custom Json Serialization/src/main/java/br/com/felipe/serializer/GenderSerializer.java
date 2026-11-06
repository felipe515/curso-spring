package br.com.felipe.serializer;

import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.SerializationContext;

public class GenderSerializer extends ValueSerializer<String> {

    @Override
    public void serialize(String gender, JsonGenerator gen,
                          SerializationContext ctxt) {
        String formatedGender = "Male".equals(gender) ? "M" : "F";
        gen.writeString(formatedGender);
    }
}