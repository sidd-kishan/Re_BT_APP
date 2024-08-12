/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

private final class MapTypeAdapterFactory.Adapter<K, V>
extends TypeAdapter<Map<K, V>> {
    private final ObjectConstructor<? extends Map<K, V>> constructor;
    private final TypeAdapter<K> keyTypeAdapter;
    final MapTypeAdapterFactory this$0;
    private final TypeAdapter<V> valueTypeAdapter;

    public MapTypeAdapterFactory.Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
        this.this$0 = mapTypeAdapterFactory;
        this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(gson, typeAdapter, type);
        this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(gson, typeAdapter2, type2);
        this.constructor = objectConstructor;
    }

    private String keyToString(JsonElement jsonElement) {
        if (!jsonElement.isJsonPrimitive()) {
            if (!jsonElement.isJsonNull()) throw new AssertionError();
            return "null";
        }
        if (((JsonPrimitive)(jsonElement = jsonElement.getAsJsonPrimitive())).isNumber()) {
            return String.valueOf(((JsonPrimitive)jsonElement).getAsNumber());
        }
        if (((JsonPrimitive)jsonElement).isBoolean()) {
            return Boolean.toString(((JsonPrimitive)jsonElement).getAsBoolean());
        }
        if (!((JsonPrimitive)jsonElement).isString()) throw new AssertionError();
        return ((JsonPrimitive)jsonElement).getAsString();
    }

    @Override
    public Map<K, V> read(JsonReader object) throws IOException {
        JsonToken jsonToken = ((JsonReader)object).peek();
        if (jsonToken == JsonToken.NULL) {
            ((JsonReader)object).nextNull();
            return null;
        }
        Map<JsonToken, V> map = this.constructor.construct();
        if (jsonToken == JsonToken.BEGIN_ARRAY) {
            ((JsonReader)object).beginArray();
            while (((JsonReader)object).hasNext()) {
                ((JsonReader)object).beginArray();
                jsonToken = this.keyTypeAdapter.read((JsonReader)object);
                if (map.put(jsonToken, this.valueTypeAdapter.read((JsonReader)object)) != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("duplicate key: ");
                    ((StringBuilder)object).append((Object)jsonToken);
                    throw new JsonSyntaxException(((StringBuilder)object).toString());
                }
                ((JsonReader)object).endArray();
            }
            ((JsonReader)object).endArray();
        } else {
            ((JsonReader)object).beginObject();
            while (((JsonReader)object).hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue((JsonReader)object);
                jsonToken = this.keyTypeAdapter.read((JsonReader)object);
                if (map.put(jsonToken, this.valueTypeAdapter.read((JsonReader)object)) == null) continue;
                object = new StringBuilder();
                ((StringBuilder)object).append("duplicate key: ");
                ((StringBuilder)object).append((Object)jsonToken);
                throw new JsonSyntaxException(((StringBuilder)object).toString());
            }
            ((JsonReader)object).endObject();
        }
        return map;
    }

    @Override
    public void write(JsonWriter jsonWriter, Map<K, V> object) throws IOException {
        int n;
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        if (!this.this$0.complexMapKeySerialization) {
            jsonWriter.beginObject();
            object = object.entrySet().iterator();
            while (true) {
                if (!object.hasNext()) {
                    jsonWriter.endObject();
                    return;
                }
                Map.Entry entry = (Map.Entry)object.next();
                jsonWriter.name(String.valueOf(entry.getKey()));
                this.valueTypeAdapter.write(jsonWriter, entry.getValue());
            }
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(object.size());
        ArrayList arrayList2 = new ArrayList(object.size());
        Iterator iterator = object.entrySet().iterator();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            object = this.keyTypeAdapter.toJsonTree(entry.getKey());
            arrayList.add(object);
            arrayList2.add(entry.getValue());
            n = !((JsonElement)object).isJsonArray() && !((JsonElement)object).isJsonObject() ? 0 : 1;
            n4 |= n;
        }
        if (n4 != 0) {
            jsonWriter.beginArray();
            n = arrayList.size();
            for (n4 = n3; n4 < n; ++n4) {
                jsonWriter.beginArray();
                Streams.write((JsonElement)arrayList.get(n4), jsonWriter);
                this.valueTypeAdapter.write(jsonWriter, arrayList2.get(n4));
                jsonWriter.endArray();
            }
            jsonWriter.endArray();
        } else {
            jsonWriter.beginObject();
            n = arrayList.size();
            for (n4 = n2; n4 < n; ++n4) {
                jsonWriter.name(this.keyToString((JsonElement)arrayList.get(n4)));
                this.valueTypeAdapter.write(jsonWriter, arrayList2.get(n4));
            }
            jsonWriter.endObject();
        }
    }
}
