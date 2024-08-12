/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonParseException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;

final class ToNumberPolicy.3
extends ToNumberPolicy {
    @Override
    public Number readNumber(JsonReader jsonReader) throws IOException, JsonParseException {
        long l;
        String string = jsonReader.nextString();
        try {
            l = Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            try {
                Double d = Double.valueOf(string);
                if (!d.isInfinite()) {
                    if (!d.isNaN()) return d;
                }
                if (jsonReader.isLenient()) {
                    return d;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("JSON forbids NaN and infinities: ");
                stringBuilder.append(d);
                stringBuilder.append("; at path ");
                stringBuilder.append(jsonReader.getPath());
                MalformedJsonException malformedJsonException = new MalformedJsonException(stringBuilder.toString());
                throw malformedJsonException;
            }
            catch (NumberFormatException numberFormatException2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot parse ");
                stringBuilder.append(string);
                stringBuilder.append("; at path ");
                stringBuilder.append(jsonReader.getPath());
                throw new JsonParseException(stringBuilder.toString(), numberFormatException2);
            }
        }
        return l;
    }
}
