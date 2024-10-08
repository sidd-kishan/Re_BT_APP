/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray
extends JsonElement
implements Iterable<JsonElement> {
    private final List<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList<JsonElement>();
    }

    public JsonArray(int n) {
        this.elements = new ArrayList<JsonElement>(n);
    }

    public void add(JsonElement jsonElement) {
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement2);
    }

    public void add(Boolean object) {
        List<JsonElement> list = this.elements;
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Boolean)object);
        list.add((JsonElement)object);
    }

    public void add(Character object) {
        List<JsonElement> list = this.elements;
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Character)object);
        list.add((JsonElement)object);
    }

    public void add(Number object) {
        List<JsonElement> list = this.elements;
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Number)object);
        list.add((JsonElement)object);
    }

    public void add(String object) {
        List<JsonElement> list = this.elements;
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((String)object);
        list.add((JsonElement)object);
    }

    public void addAll(JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    @Override
    public JsonArray deepCopy() {
        if (this.elements.isEmpty()) return new JsonArray();
        JsonArray jsonArray = new JsonArray(this.elements.size());
        Iterator<JsonElement> iterator = this.elements.iterator();
        while (iterator.hasNext()) {
            jsonArray.add(iterator.next().deepCopy());
        }
        return jsonArray;
    }

    public boolean equals(Object object) {
        boolean bl = object == this || object instanceof JsonArray && ((JsonArray)object).elements.equals(this.elements);
        return bl;
    }

    public JsonElement get(int n) {
        return this.elements.get(n);
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBigDecimal();
    }

    @Override
    public BigInteger getAsBigInteger() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBigInteger();
    }

    @Override
    public boolean getAsBoolean() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsBoolean();
    }

    @Override
    public byte getAsByte() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsByte();
    }

    @Override
    public char getAsCharacter() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsCharacter();
    }

    @Override
    public double getAsDouble() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsDouble();
    }

    @Override
    public float getAsFloat() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsFloat();
    }

    @Override
    public int getAsInt() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsInt();
    }

    @Override
    public long getAsLong() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsLong();
    }

    @Override
    public Number getAsNumber() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsNumber();
    }

    @Override
    public short getAsShort() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsShort();
    }

    @Override
    public String getAsString() {
        if (this.elements.size() != 1) throw new IllegalStateException();
        return this.elements.get(0).getAsString();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public JsonElement remove(int n) {
        return this.elements.remove(n);
    }

    public boolean remove(JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public JsonElement set(int n, JsonElement jsonElement) {
        return this.elements.set(n, jsonElement);
    }

    public int size() {
        return this.elements.size();
    }
}
