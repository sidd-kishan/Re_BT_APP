/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

static class NumberTypeAdapter.2 {
    static final int[] $SwitchMap$com$google$gson$stream$JsonToken;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[JsonToken.values().length];
        $SwitchMap$com$google$gson$stream$JsonToken = nArray;
        try {
            nArray[JsonToken.NULL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            NumberTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            NumberTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
