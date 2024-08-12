/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

static class Gson.FutureTypeAdapter<T>
extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;

    Gson.FutureTypeAdapter() {
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter == null) throw new IllegalStateException();
        return typeAdapter.read(jsonReader);
    }

    public void setDelegate(TypeAdapter<T> typeAdapter) {
        if (this.delegate != null) throw new AssertionError();
        this.delegate = typeAdapter;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter == null) throw new IllegalStateException();
        typeAdapter.write(jsonWriter, t);
    }
}
