/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonReader;
import java.io.IOException;

final class ToNumberPolicy.1
extends ToNumberPolicy {
    @Override
    public Double readNumber(JsonReader jsonReader) throws IOException {
        return jsonReader.nextDouble();
    }
}
