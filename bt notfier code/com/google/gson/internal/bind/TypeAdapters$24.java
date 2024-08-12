/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Currency;

class TypeAdapters.24
extends TypeAdapter<Currency> {
    TypeAdapters.24() {
    }

    @Override
    public Currency read(JsonReader jsonReader) throws IOException {
        return Currency.getInstance(jsonReader.nextString());
    }

    @Override
    public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
        jsonWriter.value(currency.getCurrencyCode());
    }
}
