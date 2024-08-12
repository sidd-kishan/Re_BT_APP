/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T>
extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type clazz, Object object) {
        Class<?> clazz2 = clazz;
        if (object == null) return clazz2;
        if (clazz != Object.class && !(clazz instanceof TypeVariable)) {
            clazz2 = clazz;
            if (!(clazz instanceof Class)) return clazz2;
        }
        clazz2 = object.getClass();
        return clazz2;
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        return this.delegate.read(jsonReader);
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        Object object = this.delegate;
        Object object2 = this.getRuntimeTypeIfMoreSpecific(this.type, t);
        if (object2 != this.type && (object = this.context.getAdapter(TypeToken.get((Type)object2))) instanceof ReflectiveTypeAdapterFactory.Adapter && !((object2 = this.delegate) instanceof ReflectiveTypeAdapterFactory.Adapter)) {
            object = object2;
        }
        ((TypeAdapter)object).write(jsonWriter, t);
    }
}
