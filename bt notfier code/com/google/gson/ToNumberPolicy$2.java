/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import java.io.IOException;

final class ToNumberPolicy.2
extends ToNumberPolicy {
    @Override
    public Number readNumber(JsonReader jsonReader) throws IOException {
        return new LazilyParsedNumber(jsonReader.nextString());
    }
}
