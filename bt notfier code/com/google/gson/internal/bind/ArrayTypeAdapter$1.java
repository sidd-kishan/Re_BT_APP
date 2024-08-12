/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

class ArrayTypeAdapter.1
implements TypeAdapterFactory {
    ArrayTypeAdapter.1() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> object) {
        if (!((object = ((TypeToken)object).getType()) instanceof GenericArrayType)) {
            if (!(object instanceof Class)) return null;
            if (!((Class)object).isArray()) {
                return null;
            }
        }
        object = $Gson$Types.getArrayComponentType((Type)object);
        return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get((Type)object)), $Gson$Types.getRawType((Type)object));
    }
}
