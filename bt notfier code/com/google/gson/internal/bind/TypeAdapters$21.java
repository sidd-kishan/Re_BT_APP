/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class TypeAdapters.21
extends TypeAdapter<URI> {
    TypeAdapters.21() {
    }

    @Override
    public URI read(JsonReader object) throws IOException {
        JsonToken jsonToken = ((JsonReader)object).peek();
        JsonToken jsonToken2 = JsonToken.NULL;
        Object var2_5 = null;
        if (jsonToken == jsonToken2) {
            ((JsonReader)object).nextNull();
            return null;
        }
        try {
            object = ((JsonReader)object).nextString();
            object = "null".equals(object) ? var2_5 : new URI((String)object);
            return object;
        }
        catch (URISyntaxException uRISyntaxException) {
            throw new JsonIOException(uRISyntaxException);
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, URI object) throws IOException {
        object = object == null ? null : ((URI)object).toASCIIString();
        jsonWriter.value((String)object);
    }
}
