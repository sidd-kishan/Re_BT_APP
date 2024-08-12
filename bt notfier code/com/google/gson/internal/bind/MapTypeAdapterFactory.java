/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class MapTypeAdapterFactory
implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean bl) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = bl;
    }

    private TypeAdapter<?> getKeyAdapter(Gson typeAdapter, Type type) {
        typeAdapter = type != Boolean.TYPE && type != Boolean.class ? ((Gson)((Object)typeAdapter)).getAdapter(TypeToken.get(type)) : TypeAdapters.BOOLEAN_AS_STRING;
        return typeAdapter;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> object) {
        Type[] typeArray = ((TypeToken)object).getType();
        if (!Map.class.isAssignableFrom(((TypeToken)object).getRawType())) {
            return null;
        }
        typeArray = $Gson$Types.getMapKeyAndValueTypes((Type)typeArray, $Gson$Types.getRawType((Type)typeArray));
        TypeAdapter<?> typeAdapter = this.getKeyAdapter(gson, typeArray[0]);
        TypeAdapter<?> typeAdapter2 = gson.getAdapter(TypeToken.get(typeArray[1]));
        object = this.constructorConstructor.get(object);
        return new Adapter(gson, typeArray[0], typeAdapter, typeArray[1], typeAdapter2, (ObjectConstructor<Map<?, ?>>)object);
    }

    private final class Adapter<K, V>
    extends TypeAdapter<Map<K, V>> {
        private final TypeAdapter<K> keyTypeAdapter;
        private final TypeAdapter<V> valueTypeAdapter;
        private final ObjectConstructor<? extends Map<K, V>> constructor;

        public Adapter(Gson context, Type keyType, TypeAdapter<K> keyTypeAdapter, Type valueType, TypeAdapter<V> valueTypeAdapter, ObjectConstructor<? extends Map<K, V>> constructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(context, keyTypeAdapter, keyType);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(context, valueTypeAdapter, valueType);
            this.constructor = constructor;
        }

        @Override
        public Map<K, V> read(JsonReader in) throws IOException {
            JsonToken peek = in.peek();
            if (peek == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Map<K, V> map = this.constructor.construct();
            if (peek != JsonToken.BEGIN_ARRAY) {
                in.beginObject();
                while (in.hasNext()) {
                    V value;
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(in);
                    K key = this.keyTypeAdapter.read(in);
                    V replaced = map.put(key, value = this.valueTypeAdapter.read(in));
                    if (replaced == null) continue;
                    throw new JsonSyntaxException("duplicate key: " + key);
                }
                in.endObject();
            } else {
                in.beginArray();
                while (in.hasNext()) {
                    in.beginArray();
                    K key = this.keyTypeAdapter.read(in);
                    V value = this.valueTypeAdapter.read(in);
                    V replaced = map.put(key, value);
                    if (replaced != null) {
                        throw new JsonSyntaxException("duplicate key: " + key);
                    }
                    in.endArray();
                }
                in.endArray();
            }
            return map;
        }

        @Override
        public void write(JsonWriter out, Map<K, V> map) throws IOException {
            JsonElement keyElement;
            if (map == null) {
                out.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                out.beginObject();
                Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        out.endObject();
                        return;
                    }
                    Map.Entry<K, V> entry = iterator.next();
                    out.name(String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(out, entry.getValue());
                }
            }
            boolean hasComplexKeys = false;
            ArrayList<JsonElement> keys = new ArrayList<JsonElement>(map.size());
            ArrayList<V> values = new ArrayList<V>(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                keyElement = this.keyTypeAdapter.toJsonTree(entry.getKey());
                keys.add(keyElement);
                values.add(entry.getValue());
                hasComplexKeys |= keyElement.isJsonArray() || keyElement.isJsonObject();
            }
            if (hasComplexKeys) {
                out.beginArray();
                int size = keys.size();
                for (int i = 0; i < size; ++i) {
                    out.beginArray();
                    Streams.write((JsonElement)keys.get(i), out);
                    this.valueTypeAdapter.write(out, values.get(i));
                    out.endArray();
                }
                out.endArray();
            } else {
                out.beginObject();
                int size = keys.size();
                for (int i = 0; i < size; ++i) {
                    keyElement = (JsonElement)keys.get(i);
                    out.name(this.keyToString(keyElement));
                    this.valueTypeAdapter.write(out, values.get(i));
                }
                out.endObject();
            }
        }

        private String keyToString(JsonElement keyElement) {
            if (!keyElement.isJsonPrimitive()) {
                if (!keyElement.isJsonNull()) throw new AssertionError();
                return "null";
            }
            JsonPrimitive primitive = keyElement.getAsJsonPrimitive();
            if (primitive.isNumber()) {
                return String.valueOf(primitive.getAsNumber());
            }
            if (primitive.isBoolean()) {
                return Boolean.toString(primitive.getAsBoolean());
            }
            if (!primitive.isString()) throw new AssertionError();
            return primitive.getAsString();
        }
    }
}
