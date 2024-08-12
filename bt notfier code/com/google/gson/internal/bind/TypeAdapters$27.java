/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

class TypeAdapters.27
extends TypeAdapter<JsonElement> {
    TypeAdapters.27() {
    }

    @Override
    public JsonElement read(JsonReader jsonReader) throws IOException {
        if (jsonReader instanceof JsonTreeReader) {
            return ((JsonTreeReader)jsonReader).nextJsonElement();
        }
        switch (TypeAdapters.34.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            default: {
                throw new IllegalArgumentException();
            }
            case 6: {
                JsonObject jsonObject = new JsonObject();
                jsonReader.beginObject();
                while (true) {
                    if (!jsonReader.hasNext()) {
                        jsonReader.endObject();
                        return jsonObject;
                    }
                    jsonObject.add(jsonReader.nextName(), this.read(jsonReader));
                }
            }
            case 5: {
                JsonArray jsonArray = new JsonArray();
                jsonReader.beginArray();
                while (true) {
                    if (!jsonReader.hasNext()) {
                        jsonReader.endArray();
                        return jsonArray;
                    }
                    jsonArray.add(this.read(jsonReader));
                }
            }
            case 4: {
                jsonReader.nextNull();
                return JsonNull.INSTANCE;
            }
            case 3: {
                return new JsonPrimitive(jsonReader.nextString());
            }
            case 2: {
                return new JsonPrimitive(jsonReader.nextBoolean());
            }
            case 1: 
        }
        return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
    }

    @Override
    public void write(JsonWriter object, JsonElement entry2) throws IOException {
        if (entry2 != null && !((JsonElement)((Object)entry2)).isJsonNull()) {
            if (((JsonElement)((Object)entry2)).isJsonPrimitive()) {
                if (((JsonPrimitive)((Object)(entry2 = ((JsonElement)((Object)entry2)).getAsJsonPrimitive()))).isNumber()) {
                    ((JsonWriter)object).value(((JsonPrimitive)((Object)entry2)).getAsNumber());
                } else if (((JsonPrimitive)((Object)entry2)).isBoolean()) {
                    ((JsonWriter)object).value(((JsonPrimitive)((Object)entry2)).getAsBoolean());
                } else {
                    ((JsonWriter)object).value(((JsonPrimitive)((Object)entry2)).getAsString());
                }
            } else if (((JsonElement)((Object)entry2)).isJsonArray()) {
                ((JsonWriter)object).beginArray();
                entry2 = ((JsonElement)((Object)entry2)).getAsJsonArray().iterator();
                while (entry2.hasNext()) {
                    this.write((JsonWriter)object, (JsonElement)entry2.next());
                }
                ((JsonWriter)object).endArray();
            } else {
                if (!((JsonElement)((Object)entry2)).isJsonObject()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Couldn't write ");
                    ((StringBuilder)object).append(entry2.getClass());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                ((JsonWriter)object).beginObject();
                for (Map.Entry<String, JsonElement> entry2 : ((JsonElement)((Object)entry2)).getAsJsonObject().entrySet()) {
                    ((JsonWriter)object).name(entry2.getKey());
                    this.write((JsonWriter)object, entry2.getValue());
                }
                ((JsonWriter)object).endObject();
            }
        } else {
            ((JsonWriter)object).nullValue();
        }
    }
}
