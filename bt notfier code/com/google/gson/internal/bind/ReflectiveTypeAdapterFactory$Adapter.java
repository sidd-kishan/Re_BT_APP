/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

public static final class ReflectiveTypeAdapterFactory.Adapter<T>
extends TypeAdapter<T> {
    private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
    private final ObjectConstructor<T> constructor;

    ReflectiveTypeAdapterFactory.Adapter(ObjectConstructor<T> objectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> map) {
        this.constructor = objectConstructor;
        this.boundFields = map;
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        T t = this.constructor.construct();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                Object object = jsonReader.nextName();
                if ((object = this.boundFields.get(object)) != null && ((ReflectiveTypeAdapterFactory.BoundField)object).deserialized) {
                    object.read(jsonReader, t);
                    continue;
                }
                jsonReader.skipValue();
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new AssertionError((Object)illegalAccessException);
        }
        catch (IllegalStateException illegalStateException) {
            JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(illegalStateException);
            throw jsonSyntaxException;
        }
        jsonReader.endObject();
        return t;
    }

    @Override
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (t == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        try {
            for (ReflectiveTypeAdapterFactory.BoundField boundField : this.boundFields.values()) {
                if (!boundField.writeField(t)) continue;
                jsonWriter.name(boundField.name);
                boundField.write(jsonWriter, t);
            }
            jsonWriter.endObject();
        }
        catch (IllegalAccessException illegalAccessException) {
            AssertionError assertionError = new AssertionError((Object)illegalAccessException);
            throw assertionError;
        }
    }
}
