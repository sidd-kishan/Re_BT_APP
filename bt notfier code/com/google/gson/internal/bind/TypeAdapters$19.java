/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.19
extends TypeAdapter<StringBuffer> {
    TypeAdapters.19() {
    }

    @Override
    public StringBuffer read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return new StringBuffer(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, StringBuffer charSequence) throws IOException {
        charSequence = charSequence == null ? null : charSequence.toString();
        jsonWriter.value((String)charSequence);
    }
}
