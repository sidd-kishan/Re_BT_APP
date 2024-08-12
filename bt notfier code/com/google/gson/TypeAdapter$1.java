/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapter.1
extends TypeAdapter<T> {
    final TypeAdapter this$0;

    TypeAdapter.1(TypeAdapter typeAdapter) {
        this.this$0 = typeAdapter;
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return this.this$0.read(jsonReader);
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.nullValue();
        } else {
            this.this$0.write(jsonWriter, t);
        }
    }
}
