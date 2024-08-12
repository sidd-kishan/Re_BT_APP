/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.31
implements TypeAdapterFactory {
    final Class val$boxed;
    final TypeAdapter val$typeAdapter;
    final Class val$unboxed;

    TypeAdapters.31(Class clazz, Class clazz2, TypeAdapter typeAdapter) {
        this.val$unboxed = clazz;
        this.val$boxed = clazz2;
        this.val$typeAdapter = typeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson clazz, TypeToken<T> typeToken) {
        clazz = typeToken.getRawType();
        clazz = clazz != this.val$unboxed && clazz != this.val$boxed ? null : this.val$typeAdapter;
        return clazz;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory[type=");
        stringBuilder.append(this.val$boxed.getName());
        stringBuilder.append("+");
        stringBuilder.append(this.val$unboxed.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append(this.val$typeAdapter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
