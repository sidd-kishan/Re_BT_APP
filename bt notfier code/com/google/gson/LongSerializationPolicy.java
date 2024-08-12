/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

public abstract class LongSerializationPolicy
extends Enum<LongSerializationPolicy> {
    private static final LongSerializationPolicy[] $VALUES;
    public static final /* enum */ LongSerializationPolicy DEFAULT;
    public static final /* enum */ LongSerializationPolicy STRING;

    static {
        LongSerializationPolicy longSerializationPolicy;
        DEFAULT = new LongSerializationPolicy(){

            @Override
            public JsonElement serialize(Long value) {
                if (value != null) return new JsonPrimitive(value);
                return JsonNull.INSTANCE;
            }
        };
        STRING = longSerializationPolicy = new LongSerializationPolicy(){

            @Override
            public JsonElement serialize(Long value) {
                if (value != null) return new JsonPrimitive(value.toString());
                return JsonNull.INSTANCE;
            }
        };
        $VALUES = new LongSerializationPolicy[]{DEFAULT, longSerializationPolicy};
    }

    public static LongSerializationPolicy valueOf(String string) {
        return Enum.valueOf(LongSerializationPolicy.class, string);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[])$VALUES.clone();
    }

    public abstract JsonElement serialize(Long var1);
}
