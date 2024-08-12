/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.sql.SqlTimeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.sql.Time;

class SqlTimeTypeAdapter.1
implements TypeAdapterFactory {
    SqlTimeTypeAdapter.1() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson object, TypeToken<T> object2) {
        object2 = ((TypeToken)object2).getRawType();
        object = null;
        if (object2 != Time.class) return object;
        object = new SqlTimeTypeAdapter(null);
        return object;
    }
}
