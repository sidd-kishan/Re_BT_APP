/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

class ReflectiveTypeAdapterFactory.1
extends ReflectiveTypeAdapterFactory.BoundField {
    final ReflectiveTypeAdapterFactory this$0;
    final Gson val$context;
    final Field val$field;
    final TypeToken val$fieldType;
    final boolean val$isPrimitive;
    final boolean val$jsonAdapterPresent;
    final TypeAdapter val$typeAdapter;

    ReflectiveTypeAdapterFactory.1(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String string, boolean bl, boolean bl2, Field field, boolean bl3, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean bl4) {
        this.this$0 = reflectiveTypeAdapterFactory;
        this.val$field = field;
        this.val$jsonAdapterPresent = bl3;
        this.val$typeAdapter = typeAdapter;
        this.val$context = gson;
        this.val$fieldType = typeToken;
        this.val$isPrimitive = bl4;
        super(string, bl, bl2);
    }

    void read(JsonReader jsonReader, Object object) throws IOException, IllegalAccessException {
        if ((jsonReader = this.val$typeAdapter.read(jsonReader)) == null) {
            if (this.val$isPrimitive) return;
        }
        this.val$field.set(object, jsonReader);
    }

    @Override
    void write(JsonWriter jsonWriter, Object typeAdapter) throws IOException, IllegalAccessException {
        Object object = this.val$field.get(typeAdapter);
        typeAdapter = this.val$jsonAdapterPresent ? this.val$typeAdapter : new TypeAdapterRuntimeTypeWrapper<Object>(this.val$context, this.val$typeAdapter, this.val$fieldType.getType());
        ((TypeAdapter)typeAdapter).write(jsonWriter, object);
    }

    public boolean writeField(Object object) throws IOException, IllegalAccessException {
        boolean bl = this.serialized;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (this.val$field.get(object) == object) return bl2;
        bl2 = true;
        return bl2;
    }
}
