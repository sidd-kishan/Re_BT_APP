/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

static abstract class ReflectiveTypeAdapterFactory.BoundField {
    final boolean deserialized;
    final String name;
    final boolean serialized;

    protected ReflectiveTypeAdapterFactory.BoundField(String string, boolean bl, boolean bl2) {
        this.name = string;
        this.serialized = bl;
        this.deserialized = bl2;
    }

    abstract void read(JsonReader var1, Object var2) throws IOException, IllegalAccessException;

    abstract void write(JsonWriter var1, Object var2) throws IOException, IllegalAccessException;

    abstract boolean writeField(Object var1) throws IOException, IllegalAccessException;
}
