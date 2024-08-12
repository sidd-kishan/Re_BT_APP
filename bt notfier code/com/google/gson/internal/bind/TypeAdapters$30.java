/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.30
implements TypeAdapterFactory {
    final Class val$type;
    final TypeAdapter val$typeAdapter;

    TypeAdapters.30(Class clazz, TypeAdapter typeAdapter) {
        this.val$type = clazz;
        this.val$typeAdapter = typeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson typeAdapter, TypeToken<T> typeToken) {
        typeAdapter = typeToken.getRawType() == this.val$type ? this.val$typeAdapter : null;
        return typeAdapter;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory[type=");
        stringBuilder.append(this.val$type.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append(this.val$typeAdapter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
