/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;

private static final class TreeTypeAdapter.SingleTypeFactory
implements TypeAdapterFactory {
    private final JsonDeserializer<?> deserializer;
    private final TypeToken<?> exactType;
    private final Class<?> hierarchyType;
    private final boolean matchRawType;
    private final JsonSerializer<?> serializer;

    TreeTypeAdapter.SingleTypeFactory(Object object, TypeToken<?> typeToken, boolean bl, Class<?> clazz) {
        boolean bl2 = object instanceof JsonSerializer;
        Object var7_6 = null;
        Object object2 = bl2 ? (JsonSerializer)object : null;
        this.serializer = object2;
        object2 = var7_6;
        if (object instanceof JsonDeserializer) {
            object2 = (JsonDeserializer)object;
        }
        this.deserializer = object2;
        bl2 = this.serializer != null || object2 != null;
        $Gson$Preconditions.checkArgument(bl2);
        this.exactType = typeToken;
        this.matchRawType = bl;
        this.hierarchyType = clazz;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson treeTypeAdapter, TypeToken<T> typeToken) {
        TypeToken<?> typeToken2 = this.exactType;
        boolean bl = typeToken2 != null ? typeToken2.equals(typeToken) || this.matchRawType && this.exactType.getType() == typeToken.getRawType() : this.hierarchyType.isAssignableFrom(typeToken.getRawType());
        treeTypeAdapter = bl ? new TreeTypeAdapter(this.serializer, this.deserializer, (Gson)((Object)treeTypeAdapter), typeToken, this) : null;
        return treeTypeAdapter;
    }
}
