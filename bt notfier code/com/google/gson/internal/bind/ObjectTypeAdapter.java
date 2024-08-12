/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class ObjectTypeAdapter
extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = ObjectTypeAdapter.newFactory(ToNumberPolicy.DOUBLE);
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    private ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.gson = gson;
        this.toNumberStrategy = toNumberStrategy;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy != ToNumberPolicy.DOUBLE) return ObjectTypeAdapter.newFactory(toNumberStrategy);
        return DOUBLE_FACTORY;
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                if (type.getRawType() != Object.class) return null;
                return new ObjectTypeAdapter(gson, toNumberStrategy);
            }
        };
    }

    @Override
    public Object read(JsonReader jsonReader) throws IOException {
        Object object = jsonReader.peek();
        switch (2.$SwitchMap$com$google$gson$stream$JsonToken[((Enum)object).ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 6: {
                jsonReader.nextNull();
                return null;
            }
            case 5: {
                return jsonReader.nextBoolean();
            }
            case 4: {
                return this.toNumberStrategy.readNumber(jsonReader);
            }
            case 3: {
                return jsonReader.nextString();
            }
            case 2: {
                object = new LinkedTreeMap();
                jsonReader.beginObject();
                while (true) {
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        return object;
                    }
                    object.put(jsonReader.nextName(), this.read(jsonReader));
                }
            }
            case 1: 
        }
        object = new ArrayList();
        jsonReader.beginArray();
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endArray();
                return object;
            }
            object.add(this.read(jsonReader));
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, Object object) throws IOException {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        TypeAdapter<?> typeAdapter = this.gson.getAdapter(object.getClass());
        if (typeAdapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        typeAdapter.write(jsonWriter, object);
    }
}
