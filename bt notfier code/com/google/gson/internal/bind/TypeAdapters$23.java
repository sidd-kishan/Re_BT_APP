/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

class TypeAdapters.23
extends TypeAdapter<UUID> {
    TypeAdapters.23() {
    }

    @Override
    public UUID read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return UUID.fromString(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, UUID object) throws IOException {
        object = object == null ? null : ((UUID)object).toString();
        jsonWriter.value((String)object);
    }
}
