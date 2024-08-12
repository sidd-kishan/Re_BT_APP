/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.29
implements TypeAdapterFactory {
    final TypeToken val$type;
    final TypeAdapter val$typeAdapter;

    TypeAdapters.29(TypeToken typeToken, TypeAdapter typeAdapter) {
        this.val$type = typeToken;
        this.val$typeAdapter = typeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson typeAdapter, TypeToken<T> typeToken) {
        typeAdapter = typeToken.equals(this.val$type) ? this.val$typeAdapter : null;
        return typeAdapter;
    }
}
