/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;

class TypeAdapters.28
implements TypeAdapterFactory {
    TypeAdapters.28() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson clazz, TypeToken<T> object) {
        if (!Enum.class.isAssignableFrom((Class<?>)(object = ((TypeToken)object).getRawType()))) return null;
        if (object == Enum.class) {
            return null;
        }
        clazz = object;
        if (((Class)object).isEnum()) return new TypeAdapters.EnumTypeAdapter(clazz);
        clazz = ((Class)object).getSuperclass();
        return new TypeAdapters.EnumTypeAdapter(clazz);
    }
}
