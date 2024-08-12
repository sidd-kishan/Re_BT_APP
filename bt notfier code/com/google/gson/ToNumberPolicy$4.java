/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonParseException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.math.BigDecimal;

final class ToNumberPolicy.4
extends ToNumberPolicy {
    @Override
    public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
        String string = jsonReader.nextString();
        try {
            BigDecimal bigDecimal = new BigDecimal(string);
            return bigDecimal;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot parse ");
            stringBuilder.append(string);
            stringBuilder.append("; at path ");
            stringBuilder.append(jsonReader.getPath());
            throw new JsonParseException(stringBuilder.toString(), numberFormatException);
        }
    }
}
