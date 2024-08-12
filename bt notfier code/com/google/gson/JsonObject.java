/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class JsonObject
extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();

    public void add(String string, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.members;
        JsonElement jsonElement2 = jsonElement;
        if (jsonElement == null) {
            jsonElement2 = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(string, jsonElement2);
    }

    public void addProperty(String string, Boolean object) {
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Boolean)object);
        this.add(string, (JsonElement)object);
    }

    public void addProperty(String string, Character object) {
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Character)object);
        this.add(string, (JsonElement)object);
    }

    public void addProperty(String string, Number object) {
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((Number)object);
        this.add(string, (JsonElement)object);
    }

    public void addProperty(String string, String object) {
        object = object == null ? JsonNull.INSTANCE : new JsonPrimitive((String)object);
        this.add(string, (JsonElement)object);
    }

    @Override
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> iterator = this.members.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonElement> entry = iterator.next();
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object object) {
        boolean bl = object == this || object instanceof JsonObject && ((JsonObject)object).members.equals(this.members);
        return bl;
    }

    public JsonElement get(String string) {
        return this.members.get(string);
    }

    public JsonArray getAsJsonArray(String string) {
        return (JsonArray)this.members.get(string);
    }

    public JsonObject getAsJsonObject(String string) {
        return (JsonObject)this.members.get(string);
    }

    public JsonPrimitive getAsJsonPrimitive(String string) {
        return (JsonPrimitive)this.members.get(string);
    }

    public boolean has(String string) {
        return this.members.containsKey(string);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String string) {
        return this.members.remove(string);
    }

    public int size() {
        return this.members.size();
    }
}
