/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class TypeAdapters.9
extends TypeAdapter<AtomicBoolean> {
    TypeAdapters.9() {
    }

    @Override
    public AtomicBoolean read(JsonReader jsonReader) throws IOException {
        return new AtomicBoolean(jsonReader.nextBoolean());
    }

    @Override
    public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
        jsonWriter.value(atomicBoolean.get());
    }
}
