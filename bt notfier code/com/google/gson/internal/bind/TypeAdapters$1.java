/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.1
extends TypeAdapter<Class> {
    TypeAdapters.1() {
    }

    @Override
    public Class read(JsonReader jsonReader) throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    @Override
    public void write(JsonWriter object, Class clazz) throws IOException {
        object = new StringBuilder();
        ((StringBuilder)object).append("Attempted to serialize java.lang.Class: ");
        ((StringBuilder)object).append(clazz.getName());
        ((StringBuilder)object).append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(((StringBuilder)object).toString());
    }
}
