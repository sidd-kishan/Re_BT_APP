/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

class TypeAdapters.26
extends TypeAdapter<Locale> {
    TypeAdapters.26() {
    }

    @Override
    public Locale read(JsonReader object) throws IOException {
        Object object2 = ((JsonReader)object).peek();
        Object object3 = JsonToken.NULL;
        String string = null;
        if (object2 == object3) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object3 = new StringTokenizer(((JsonReader)object).nextString(), "_");
        object = ((StringTokenizer)object3).hasMoreElements() ? ((StringTokenizer)object3).nextToken() : null;
        object2 = ((StringTokenizer)object3).hasMoreElements() ? ((StringTokenizer)object3).nextToken() : null;
        if (((StringTokenizer)object3).hasMoreElements()) {
            string = ((StringTokenizer)object3).nextToken();
        }
        if (object2 == null && string == null) {
            return new Locale((String)object);
        }
        if (string != null) return new Locale((String)object, (String)object2, string);
        return new Locale((String)object, (String)object2);
    }

    @Override
    public void write(JsonWriter jsonWriter, Locale object) throws IOException {
        object = object == null ? null : ((Locale)object).toString();
        jsonWriter.value((String)object);
    }
}
