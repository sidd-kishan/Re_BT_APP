/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.sql.Date;

class SqlDateTypeAdapter.1
implements TypeAdapterFactory {
    SqlDateTypeAdapter.1() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson object, TypeToken<T> object2) {
        object2 = ((TypeToken)object2).getRawType();
        object = null;
        if (object2 != Date.class) return object;
        object = new SqlDateTypeAdapter(null);
        return object;
    }
}
