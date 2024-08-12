/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;

public final class JsonAdapterAnnotationTypeAdapterFactory
implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter != null) return this.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
        return null;
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor object, Gson typeAdapter, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        Object obj = ((ConstructorConstructor)object).get(TypeToken.get(jsonAdapter.value())).construct();
        if (obj instanceof TypeAdapter) {
            object = (TypeAdapter)obj;
        } else if (obj instanceof TypeAdapterFactory) {
            object = ((TypeAdapterFactory)obj).create((Gson)((Object)typeAdapter), typeToken);
        } else {
            boolean bl = obj instanceof JsonSerializer;
            if (!bl && !(obj instanceof JsonDeserializer)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid attempt to bind an instance of ");
                ((StringBuilder)object).append(obj.getClass().getName());
                ((StringBuilder)object).append(" as a @JsonAdapter for ");
                ((StringBuilder)object).append(typeToken.toString());
                ((StringBuilder)object).append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            JsonDeserializer jsonDeserializer = null;
            object = bl ? (JsonSerializer)obj : null;
            if (obj instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer)obj;
            }
            object = new TreeTypeAdapter((JsonSerializer<?>)object, jsonDeserializer, (Gson)((Object)typeAdapter), typeToken, null);
        }
        typeAdapter = object;
        if (object == null) return typeAdapter;
        typeAdapter = object;
        if (!jsonAdapter.nullSafe()) return typeAdapter;
        typeAdapter = ((TypeAdapter)object).nullSafe();
        return typeAdapter;
    }
}
