/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class NumberTypeAdapter
extends TypeAdapter<Number> {
    private static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = NumberTypeAdapter.newFactory(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    private final ToNumberStrategy toNumberStrategy;

    private NumberTypeAdapter(ToNumberStrategy toNumberStrategy) {
        this.toNumberStrategy = toNumberStrategy;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy != ToNumberPolicy.LAZILY_PARSED_NUMBER) return NumberTypeAdapter.newFactory(toNumberStrategy);
        return LAZILY_PARSED_NUMBER_FACTORY;
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                return type.getRawType() == Number.class ? NumberTypeAdapter.this : null;
            }
        };
    }

    @Override
    public Number read(JsonReader object) throws IOException {
        JsonToken jsonToken = ((JsonReader)object).peek();
        int n = 2.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
        if (n == 1) {
            ((JsonReader)object).nextNull();
            return null;
        }
        if (n == 2) return this.toNumberStrategy.readNumber((JsonReader)object);
        if (n == 3) {
            return this.toNumberStrategy.readNumber((JsonReader)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expecting number, got: ");
        ((StringBuilder)object).append((Object)jsonToken);
        throw new JsonSyntaxException(((StringBuilder)object).toString());
    }

    @Override
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
