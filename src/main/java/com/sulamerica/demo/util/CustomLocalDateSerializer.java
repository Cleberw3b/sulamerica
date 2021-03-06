package com.sulamerica.demo.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomLocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = -7449444168934819290L;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CustomLocalDateSerializer() {
        this(null);
    }

    public CustomLocalDateSerializer(final Class<LocalDate> t) {
        super(t);
    }

    @Override
    public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        gen.writeString(formatter.format(value));
    }
}