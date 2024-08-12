/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson.3
extends TypeAdapter<Number> {
    Gson.3() {
    }

    @Override
    public Number read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextLong();
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(number.toString());
    }
}
