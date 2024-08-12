/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

class TypeAdapters.22
extends TypeAdapter<InetAddress> {
    TypeAdapters.22() {
    }

    @Override
    public InetAddress read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) return InetAddress.getByName(jsonReader.nextString());
        jsonReader.nextNull();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, InetAddress object) throws IOException {
        object = object == null ? null : ((InetAddress)object).getHostAddress();
        jsonWriter.value((String)object);
    }
}
