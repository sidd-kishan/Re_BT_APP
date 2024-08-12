/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.LongSerializationPolicy;

final class LongSerializationPolicy.2
extends LongSerializationPolicy {
    @Override
    public JsonElement serialize(Long l) {
        if (l != null) return new JsonPrimitive(l.toString());
        return JsonNull.INSTANCE;
    }
}
