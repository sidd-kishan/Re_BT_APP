/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

private static final class CollectionTypeAdapterFactory.Adapter<E>
extends TypeAdapter<Collection<E>> {
    private final ObjectConstructor<? extends Collection<E>> constructor;
    private final TypeAdapter<E> elementTypeAdapter;

    public CollectionTypeAdapterFactory.Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
        this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(gson, typeAdapter, type);
        this.constructor = objectConstructor;
    }

    @Override
    public Collection<E> read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        Collection<E> collection = this.constructor.construct();
        jsonReader.beginArray();
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endArray();
                return collection;
            }
            collection.add(this.elementTypeAdapter.read(jsonReader));
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, Collection<E> object) throws IOException {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                jsonWriter.endArray();
                return;
            }
            Object e = object.next();
            this.elementTypeAdapter.write(jsonWriter, e);
        }
    }
}
