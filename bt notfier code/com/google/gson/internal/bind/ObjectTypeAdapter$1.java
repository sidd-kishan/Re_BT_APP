/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

class ObjectTypeAdapter.1
implements TypeAdapterFactory {
    final ToNumberStrategy val$toNumberStrategy;

    ObjectTypeAdapter.1(ToNumberStrategy toNumberStrategy) {
        this.val$toNumberStrategy = toNumberStrategy;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() != Object.class) return null;
        return new ObjectTypeAdapter(gson, this.val$toNumberStrategy, null);
    }
}
