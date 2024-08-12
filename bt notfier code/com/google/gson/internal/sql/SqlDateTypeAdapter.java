/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

final class SqlDateTypeAdapter
extends TypeAdapter<java.sql.Date> {
    static final TypeAdapterFactory FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            return typeToken.getRawType() == java.sql.Date.class ? new SqlDateTypeAdapter() : null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    private SqlDateTypeAdapter() {
    }

    @Override
    public java.sql.Date read(JsonReader object) throws IOException {
        synchronized (this) {
            if (((JsonReader)object).peek() == JsonToken.NULL) {
                ((JsonReader)object).nextNull();
                return null;
            }
            try {
                object = new java.sql.Date(this.format.parse(((JsonReader)object).nextString()).getTime());
                return object;
            }
            catch (ParseException parseException) {
                object = new JsonSyntaxException(parseException);
                throw object;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void write(JsonWriter jsonWriter, java.sql.Date object) throws IOException {
        synchronized (this) {
            String string;
            string = string == null ? null : this.format.format((Date)((Object)string));
            jsonWriter.value(string);
            return;
        }
    }
}
