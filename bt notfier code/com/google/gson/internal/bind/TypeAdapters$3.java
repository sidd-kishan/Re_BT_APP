/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.3
extends TypeAdapter<Boolean> {
    TypeAdapters.3() {
    }

    @Override
    public Boolean read(JsonReader jsonReader) throws IOException {
        JsonToken jsonToken = jsonReader.peek();
        if (jsonToken == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonToken != JsonToken.STRING) return jsonReader.nextBoolean();
        return Boolean.parseBoolean(jsonReader.nextString());
    }

    @Override
    public void write(JsonWriter jsonWriter, Boolean bl) throws IOException {
        jsonWriter.value(bl);
    }
}
