/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

class Gson.4
extends TypeAdapter<AtomicLong> {
    final TypeAdapter val$longAdapter;

    Gson.4(TypeAdapter typeAdapter) {
        this.val$longAdapter = typeAdapter;
    }

    @Override
    public AtomicLong read(JsonReader jsonReader) throws IOException {
        return new AtomicLong(((Number)this.val$longAdapter.read(jsonReader)).longValue());
    }

    @Override
    public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
        this.val$longAdapter.write(jsonWriter, atomicLong.get());
    }
}
