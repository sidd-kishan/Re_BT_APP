/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

static class ObjectTypeAdapter.2 {
    static final int[] $SwitchMap$com$google$gson$stream$JsonToken;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[JsonToken.values().length];
        $SwitchMap$com$google$gson$stream$JsonToken = nArray;
        try {
            nArray[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
