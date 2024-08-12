/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter
extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack = new ArrayList<JsonElement>();

    static {
        UNWRITABLE_WRITER = new Writer(){

            @Override
            public void write(char[] buffer, int offset, int counter) {
                throw new AssertionError();
            }

            @Override
            public void flush() {
                throw new AssertionError();
            }

            @Override
            public void close() {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new JsonPrimitive("closed");
    }

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        List<JsonElement> list = this.stack;
        return list.get(list.size() - 1);
    }

    private void put(JsonElement jsonElement) {
        if (this.pendingName != null) {
            if (!jsonElement.isJsonNull() || this.getSerializeNulls()) {
                ((JsonObject)this.peek()).add(this.pendingName, jsonElement);
            }
            this.pendingName = null;
        } else if (this.stack.isEmpty()) {
            this.product = jsonElement;
        } else {
            JsonElement jsonElement2 = this.peek();
            if (!(jsonElement2 instanceof JsonArray)) throw new IllegalStateException();
            ((JsonArray)jsonElement2).add(jsonElement);
        }
    }

    @Override
    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        this.put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override
    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        this.put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override
    public void close() throws IOException {
        if (!this.stack.isEmpty()) throw new IOException("Incomplete document");
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override
    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty()) throw new IllegalStateException();
        if (this.pendingName != null) throw new IllegalStateException();
        if (!(this.peek() instanceof JsonArray)) throw new IllegalStateException();
        List<JsonElement> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override
    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty()) throw new IllegalStateException();
        if (this.pendingName != null) throw new IllegalStateException();
        if (!(this.peek() instanceof JsonObject)) throw new IllegalStateException();
        List<JsonElement> list = this.stack;
        list.remove(list.size() - 1);
        return this;
    }

    @Override
    public void flush() throws IOException {
    }

    public JsonElement get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected one JSON element but was ");
        stringBuilder.append(this.stack);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public JsonWriter name(String string) throws IOException {
        if (string == null) throw new NullPointerException("name == null");
        if (this.stack.isEmpty()) throw new IllegalStateException();
        if (this.pendingName != null) throw new IllegalStateException();
        if (!(this.peek() instanceof JsonObject)) throw new IllegalStateException();
        this.pendingName = string;
        return this;
    }

    @Override
    public JsonWriter nullValue() throws IOException {
        this.put(JsonNull.INSTANCE);
        return this;
    }

    @Override
    public JsonWriter value(double d) throws IOException {
        if (!this.isLenient() && (Double.isNaN(d) || Double.isInfinite(d))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.put(new JsonPrimitive(d));
        return this;
    }

    @Override
    public JsonWriter value(long l) throws IOException {
        this.put(new JsonPrimitive(l));
        return this;
    }

    @Override
    public JsonWriter value(Boolean bl) throws IOException {
        if (bl == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(bl));
        return this;
    }

    @Override
    public JsonWriter value(Number number) throws IOException {
        double d;
        if (number == null) {
            return this.nullValue();
        }
        if (!this.isLenient() && (Double.isNaN(d = number.doubleValue()) || Double.isInfinite(d))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(number);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.put(new JsonPrimitive(number));
        return this;
    }

    @Override
    public JsonWriter value(String string) throws IOException {
        if (string == null) {
            return this.nullValue();
        }
        this.put(new JsonPrimitive(string));
        return this;
    }

    @Override
    public JsonWriter value(boolean bl) throws IOException {
        this.put(new JsonPrimitive(bl));
        return this;
    }
}
