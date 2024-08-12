/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.sql.SqlTimestampTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter.1
implements TypeAdapterFactory {
    SqlTimestampTypeAdapter.1() {
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() != Timestamp.class) return null;
        return new SqlTimestampTypeAdapter(gson.getAdapter(Date.class), null);
    }
}
