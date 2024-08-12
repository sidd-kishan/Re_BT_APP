/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.reflect.TypeToken;

class NumberTypeAdapter.1
implements TypeAdapterFactory {
    final NumberTypeAdapter val$adapter;

    NumberTypeAdapter.1(NumberTypeAdapter numberTypeAdapter) {
        this.val$adapter = numberTypeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson object, TypeToken<T> typeToken) {
        object = typeToken.getRawType() == Number.class ? this.val$adapter : null;
        return object;
    }
}
