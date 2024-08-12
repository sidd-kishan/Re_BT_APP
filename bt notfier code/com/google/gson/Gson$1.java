/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson.1
extends TypeAdapter<Number> {
    final Gson this$0;

    Gson.1(Gson gson) {
        this.this$0 = gson;
    }

    @Override
    public Double read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextDouble();
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        if (number == null) {
            jsonWriter.nullValue();
            return;
        }
        Gson.checkValidFloatingPoint(number.doubleValue());
        jsonWriter.value(number);
    }
}
