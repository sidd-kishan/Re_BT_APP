/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapters.1
extends TypeAdapter<T1> {
    final TypeAdapters.33 this$0;
    final Class val$requestedType;

    TypeAdapters.1(TypeAdapters.33 var1_1, Class clazz) {
        this.this$0 = var1_1;
        this.val$requestedType = clazz;
    }

    @Override
    public T1 read(JsonReader object) throws IOException {
        Object t = this.this$0.val$typeAdapter.read((JsonReader)object);
        if (t == null) return t;
        if (this.val$requestedType.isInstance(t)) {
            return t;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expected a ");
        ((StringBuilder)object).append(this.val$requestedType.getName());
        ((StringBuilder)object).append(" but was ");
        ((StringBuilder)object).append(t.getClass().getName());
        throw new JsonSyntaxException(((StringBuilder)object).toString());
    }

    @Override
    public void write(JsonWriter jsonWriter, T1 T1) throws IOException {
        this.this$0.val$typeAdapter.write(jsonWriter, T1);
    }
}
