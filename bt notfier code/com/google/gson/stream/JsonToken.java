/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

public final class JsonToken
extends Enum<JsonToken> {
    private static final JsonToken[] $VALUES;
    public static final /* enum */ JsonToken BEGIN_ARRAY;
    public static final /* enum */ JsonToken BEGIN_OBJECT;
    public static final /* enum */ JsonToken BOOLEAN;
    public static final /* enum */ JsonToken END_ARRAY;
    public static final /* enum */ JsonToken END_DOCUMENT;
    public static final /* enum */ JsonToken END_OBJECT;
    public static final /* enum */ JsonToken NAME;
    public static final /* enum */ JsonToken NULL;
    public static final /* enum */ JsonToken NUMBER;
    public static final /* enum */ JsonToken STRING;

    static {
        JsonToken jsonToken;
        BEGIN_ARRAY = new JsonToken();
        END_ARRAY = new JsonToken();
        BEGIN_OBJECT = new JsonToken();
        END_OBJECT = new JsonToken();
        NAME = new JsonToken();
        STRING = new JsonToken();
        NUMBER = new JsonToken();
        BOOLEAN = new JsonToken();
        NULL = new JsonToken();
        END_DOCUMENT = jsonToken = new JsonToken();
        $VALUES = new JsonToken[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, jsonToken};
    }

    public static JsonToken valueOf(String string) {
        return Enum.valueOf(JsonToken.class, string);
    }

    public static JsonToken[] values() {
        return (JsonToken[])$VALUES.clone();
    }
}
