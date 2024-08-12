/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Date;

class DateTypeAdapter.1
implements TypeAdapterFactory {
    DateTypeAdapter.1() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson object, TypeToken<T> typeToken) {
        object = typeToken.getRawType() == Date.class ? new DateTypeAdapter() : null;
        return object;
    }
}
