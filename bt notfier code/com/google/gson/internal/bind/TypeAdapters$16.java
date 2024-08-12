/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

class TypeAdapters.16
extends TypeAdapter<BigDecimal> {
    TypeAdapters.16() {
    }

    @Override
    public BigDecimal read(JsonReader object) throws IOException {
        if (((JsonReader)object).peek() == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        try {
            object = new BigDecimal(((JsonReader)object).nextString());
            return object;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
        jsonWriter.value(bigDecimal);
    }
}
