/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonParseException;
import com.google.gson.ToNumberStrategy;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

public abstract class ToNumberPolicy
extends Enum<ToNumberPolicy>
implements ToNumberStrategy {
    private static final ToNumberPolicy[] $VALUES;
    public static final /* enum */ ToNumberPolicy BIG_DECIMAL;
    public static final /* enum */ ToNumberPolicy DOUBLE;
    public static final /* enum */ ToNumberPolicy LAZILY_PARSED_NUMBER;
    public static final /* enum */ ToNumberPolicy LONG_OR_DOUBLE;

    static {
        ToNumberPolicy toNumberPolicy;
        DOUBLE = new ToNumberPolicy(){

            @Override
            public Double readNumber(JsonReader in) throws IOException {
                return in.nextDouble();
            }
        };
        LAZILY_PARSED_NUMBER = new ToNumberPolicy(){

            @Override
            public Number readNumber(JsonReader in) throws IOException {
                return new LazilyParsedNumber(in.nextString());
            }
        };
        LONG_OR_DOUBLE = new ToNumberPolicy(){

            @Override
            public Number readNumber(JsonReader in) throws IOException, JsonParseException {
                String value = in.nextString();
                try {
                    return Long.parseLong(value);
                }
                catch (NumberFormatException longE) {
                    try {
                        Double d = Double.valueOf(value);
                        if (!d.isInfinite()) {
                            if (!d.isNaN()) return d;
                        }
                        if (in.isLenient()) return d;
                        throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + "; at path " + in.getPreviousPath());
                    }
                    catch (NumberFormatException doubleE) {
                        throw new JsonParseException("Cannot parse " + value + "; at path " + in.getPreviousPath(), doubleE);
                    }
                }
            }
        };
        BIG_DECIMAL = toNumberPolicy = new ToNumberPolicy(){

            @Override
            public BigDecimal readNumber(JsonReader in) throws IOException {
                String value = in.nextString();
                try {
                    return new BigDecimal(value);
                }
                catch (NumberFormatException e) {
                    throw new JsonParseException("Cannot parse " + value + "; at path " + in.getPreviousPath(), e);
                }
            }
        };
        $VALUES = new ToNumberPolicy[]{DOUBLE, LAZILY_PARSED_NUMBER, LONG_OR_DOUBLE, toNumberPolicy};
    }

    public static ToNumberPolicy valueOf(String string) {
        return Enum.valueOf(ToNumberPolicy.class, string);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[])$VALUES.clone();
    }
}
