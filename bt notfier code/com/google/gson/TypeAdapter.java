/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T> {
    public final T fromJson(Reader reader) throws IOException {
        return this.read(new JsonReader(reader));
    }

    public final T fromJson(String string) throws IOException {
        return this.fromJson(new StringReader(string));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
            jsonElement = this.read(jsonTreeReader);
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
        return (T)jsonElement;
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>(){

            @Override
            public void write(JsonWriter out, T value) throws IOException {
                if (value == null) {
                    out.nullValue();
                } else {
                    TypeAdapter.this.write(out, value);
                }
            }

            @Override
            public T read(JsonReader reader) throws IOException {
                if (reader.peek() != JsonToken.NULL) return TypeAdapter.this.read(reader);
                reader.nextNull();
                return null;
            }
        };
    }

    public abstract T read(JsonReader var1) throws IOException;

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            this.toJson(stringWriter, t);
            return stringWriter.toString();
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
    }

    public final void toJson(Writer writer, T t) throws IOException {
        this.write(new JsonWriter(writer), t);
    }

    public final JsonElement toJsonTree(T object) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            this.write(jsonTreeWriter, object);
            object = jsonTreeWriter.get();
            return object;
        }
        catch (IOException iOException) {
            throw new JsonIOException(iOException);
        }
    }

    public abstract void write(JsonWriter var1, T var2) throws IOException;
}
