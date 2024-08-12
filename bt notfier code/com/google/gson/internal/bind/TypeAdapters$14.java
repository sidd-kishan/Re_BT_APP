/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.14
extends TypeAdapter<Character> {
    TypeAdapters.14() {
    }

    @Override
    public Character read(JsonReader object) throws IOException {
        if (((JsonReader)object).peek() == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        if (((String)(object = ((JsonReader)object).nextString())).length() == 1) {
            return Character.valueOf(((String)object).charAt(0));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expecting character, got: ");
        stringBuilder.append((String)object);
        throw new JsonSyntaxException(stringBuilder.toString());
    }

    @Override
    public void write(JsonWriter jsonWriter, Character object) throws IOException {
        object = object == null ? null : String.valueOf(object);
        jsonWriter.value((String)object);
    }
}
