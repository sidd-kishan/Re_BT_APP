/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.internal.bind.TreeTypeAdapter;
import java.lang.reflect.Type;

private final class TreeTypeAdapter.GsonContextImpl
implements JsonSerializationContext,
JsonDeserializationContext {
    final TreeTypeAdapter this$0;

    private TreeTypeAdapter.GsonContextImpl(TreeTypeAdapter treeTypeAdapter) {
        this.this$0 = treeTypeAdapter;
    }

    public <R> R deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
        return (R)this.this$0.gson.fromJson(jsonElement, type);
    }

    @Override
    public JsonElement serialize(Object object) {
        return this.this$0.gson.toJsonTree(object);
    }

    @Override
    public JsonElement serialize(Object object, Type type) {
        return this.this$0.gson.toJsonTree(object, type);
    }
}
