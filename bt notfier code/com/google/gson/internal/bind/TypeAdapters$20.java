/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

class TypeAdapters.20
extends TypeAdapter<URL> {
    TypeAdapters.20() {
    }

    @Override
    public URL read(JsonReader object) throws IOException {
        JsonToken jsonToken = ((JsonReader)object).peek();
        JsonToken jsonToken2 = JsonToken.NULL;
        Object var2_4 = null;
        if (jsonToken == jsonToken2) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object = "null".equals(object = ((JsonReader)object).nextString()) ? var2_4 : new URL((String)object);
        return object;
    }

    @Override
    public void write(JsonWriter jsonWriter, URL object) throws IOException {
        object = object == null ? null : ((URL)object).toExternalForm();
        jsonWriter.value((String)object);
    }
}
