/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.4
extends TypeAdapter<Boolean> {
    TypeAdapters.4() {
    }

    @Override
    public Boolean read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return Boolean.valueOf(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, Boolean object) throws IOException {
        object = object == null ? "null" : ((Boolean)object).toString();
        jsonWriter.value((String)object);
    }
}
