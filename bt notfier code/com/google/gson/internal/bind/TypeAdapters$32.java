/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.32
implements TypeAdapterFactory {
    final Class val$base;
    final Class val$sub;
    final TypeAdapter val$typeAdapter;

    TypeAdapters.32(Class clazz, Class clazz2, TypeAdapter typeAdapter) {
        this.val$base = clazz;
        this.val$sub = clazz2;
        this.val$typeAdapter = typeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson clazz, TypeToken<T> typeToken) {
        clazz = typeToken.getRawType();
        clazz = clazz != this.val$base && clazz != this.val$sub ? null : this.val$typeAdapter;
        return clazz;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory[type=");
        stringBuilder.append(this.val$base.getName());
        stringBuilder.append("+");
        stringBuilder.append(this.val$sub.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append(this.val$typeAdapter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
