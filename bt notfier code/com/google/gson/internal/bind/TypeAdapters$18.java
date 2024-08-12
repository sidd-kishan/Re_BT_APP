/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.18
extends TypeAdapter<StringBuilder> {
    TypeAdapters.18() {
    }

    @Override
    public StringBuilder read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return new StringBuilder(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, StringBuilder charSequence) throws IOException {
        charSequence = charSequence == null ? null : charSequence.toString();
        jsonWriter.value((String)charSequence);
    }
}
