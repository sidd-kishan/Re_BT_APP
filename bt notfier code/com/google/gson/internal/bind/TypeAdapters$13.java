/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.13
extends TypeAdapter<Number> {
    TypeAdapters.13() {
    }

    @Override
    public Number read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return jsonReader.nextDouble();
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
