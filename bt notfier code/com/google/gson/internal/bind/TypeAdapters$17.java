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
import java.math.BigInteger;

class TypeAdapters.17
extends TypeAdapter<BigInteger> {
    TypeAdapters.17() {
    }

    @Override
    public BigInteger read(JsonReader object) throws IOException {
        if (((JsonReader)object).peek() == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        try {
            object = new BigInteger(((JsonReader)object).nextString());
            return object;
        }
        catch (NumberFormatException numberFormatException) {
            throw new JsonSyntaxException(numberFormatException);
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
        jsonWriter.value(bigInteger);
    }
}
