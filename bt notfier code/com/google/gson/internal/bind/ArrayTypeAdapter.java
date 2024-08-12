/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E>
extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType)) {
                if (!(type instanceof Class)) return null;
                if (!((Class)type).isArray()) {
                    return null;
                }
            }
            Type componentType = $Gson$Types.getArrayComponentType(type);
            TypeAdapter<?> componentTypeAdapter = gson.getAdapter(TypeToken.get(componentType));
            ArrayTypeAdapter arrayAdapter = new ArrayTypeAdapter(gson, componentTypeAdapter, $Gson$Types.getRawType(componentType));
            return arrayAdapter;
        }
    };
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> clazz) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(gson, typeAdapter, clazz);
        this.componentType = clazz;
    }

    @Override
    public Object read(JsonReader object) throws IOException {
        if (((JsonReader)object).peek() == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        ArrayList<E> arrayList = new ArrayList<E>();
        ((JsonReader)object).beginArray();
        while (((JsonReader)object).hasNext()) {
            arrayList.add(this.componentTypeAdapter.read((JsonReader)object));
        }
        ((JsonReader)object).endArray();
        int n = arrayList.size();
        object = Array.newInstance(this.componentType, n);
        int n2 = 0;
        while (n2 < n) {
            Array.set(object, n2, arrayList.get(n2));
            ++n2;
        }
        return object;
    }

    @Override
    public void write(JsonWriter jsonWriter, Object object) throws IOException {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int n = 0;
        int n2 = Array.getLength(object);
        while (true) {
            if (n >= n2) {
                jsonWriter.endArray();
                return;
            }
            Object object2 = Array.get(object, n);
            this.componentTypeAdapter.write(jsonWriter, object2);
            ++n;
        }
    }
}
