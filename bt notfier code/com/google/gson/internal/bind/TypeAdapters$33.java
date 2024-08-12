/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.33
implements TypeAdapterFactory {
    final Class val$clazz;
    final TypeAdapter val$typeAdapter;

    TypeAdapters.33(Class clazz, TypeAdapter typeAdapter) {
        this.val$clazz = clazz;
        this.val$typeAdapter = typeAdapter;
    }

    public <T2> TypeAdapter<T2> create(Gson clazz, TypeToken<T2> typeToken) {
        clazz = typeToken.getRawType();
        if (this.val$clazz.isAssignableFrom(clazz)) return new /* Unavailable Anonymous Inner Class!! */;
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory[typeHierarchy=");
        stringBuilder.append(this.val$clazz.getName());
        stringBuilder.append(",adapter=");
        stringBuilder.append(this.val$typeAdapter);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
