/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.15
extends TypeAdapter<String> {
    TypeAdapters.15() {
    }

    @Override
    public String read(JsonReader jsonReader) throws IOException {
        JsonToken jsonToken = jsonReader.peek();
        if (jsonToken == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        if (jsonToken != JsonToken.BOOLEAN) return jsonReader.nextString();
        return Boolean.toString(jsonReader.nextBoolean());
    }

    @Override
    public void write(JsonWriter jsonWriter, String string) throws IOException {
        jsonWriter.value(string);
    }
}
