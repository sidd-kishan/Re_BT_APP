/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Excluder.1
extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final Excluder this$0;
    final Gson val$gson;
    final boolean val$skipDeserialize;
    final boolean val$skipSerialize;
    final TypeToken val$type;

    Excluder.1(Excluder excluder, boolean bl, boolean bl2, Gson gson, TypeToken typeToken) {
        this.this$0 = excluder;
        this.val$skipDeserialize = bl;
        this.val$skipSerialize = bl2;
        this.val$gson = gson;
        this.val$type = typeToken;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) return typeAdapter;
        this.delegate = typeAdapter = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
        return typeAdapter;
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        if (!this.val$skipDeserialize) return this.delegate().read(jsonReader);
        jsonReader.skipValue();
        return null;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.val$skipSerialize) {
            jsonWriter.nullValue();
            return;
        }
        this.delegate().write(jsonWriter, t);
    }
}
