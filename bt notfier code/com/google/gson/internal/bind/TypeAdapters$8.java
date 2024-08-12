/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class TypeAdapters.8
extends TypeAdapter<AtomicInteger> {
    TypeAdapters.8() {
    }

    @Override
    public AtomicInteger read(JsonReader object) throws IOException {
        try {
            object = new AtomicInteger(((JsonReader)object).nextInt());
            return object;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
        jsonWriter.value(atomicInteger.get());
    }
}
