/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionTypeAdapterFactory
implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<T> clazz = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(clazz)) {
            return null;
        }
        type = $Gson$Types.getCollectionElementType(type, clazz);
        return new Adapter(gson, type, gson.getAdapter(TypeToken.get(type)), this.constructorConstructor.get(typeToken));
    }

    private static final class Adapter<E>
    extends TypeAdapter<Collection<E>> {
        private final TypeAdapter<E> elementTypeAdapter;
        private final ObjectConstructor<? extends Collection<E>> constructor;

        public Adapter(Gson context, Type elementType, TypeAdapter<E> elementTypeAdapter, ObjectConstructor<? extends Collection<E>> constructor) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(context, elementTypeAdapter, elementType);
            this.constructor = constructor;
        }

        @Override
        public Collection<E> read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Collection<E> collection = this.constructor.construct();
            in.beginArray();
            while (true) {
                if (!in.hasNext()) {
                    in.endArray();
                    return collection;
                }
                E instance = this.elementTypeAdapter.read(in);
                collection.add(instance);
            }
        }

        @Override
        public void write(JsonWriter out, Collection<E> collection) throws IOException {
            if (collection == null) {
                out.nullValue();
                return;
            }
            out.beginArray();
            Iterator<E> iterator = collection.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    out.endArray();
                    return;
                }
                E element = iterator.next();
                this.elementTypeAdapter.write(out, element);
            }
        }
    }
}
