/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber
extends Number {
    private final String value;

    public LazilyParsedNumber(String string) {
        this.value = string;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.value);
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof LazilyParsedNumber)) return false;
        Object object2 = (LazilyParsedNumber)object;
        object = this.value;
        object2 = ((LazilyParsedNumber)object2).value;
        boolean bl2 = bl;
        if (object == object2) return bl2;
        bl2 = ((String)object).equals(object2) ? bl : false;
        return bl2;
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public int intValue() {
        try {
            int n = Integer.parseInt(this.value);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            long l;
            try {
                l = Long.parseLong(this.value);
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigDecimal(this.value).intValue();
            }
            return (int)l;
        }
    }

    @Override
    public long longValue() {
        try {
            long l = Long.parseLong(this.value);
            return l;
        }
        catch (NumberFormatException numberFormatException) {
            return new BigDecimal(this.value).longValue();
        }
    }

    public String toString() {
        return this.value;
    }
}
