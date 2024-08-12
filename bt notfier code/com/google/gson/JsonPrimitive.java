/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive
extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean bl) {
        this.value = $Gson$Preconditions.checkNotNull(bl);
    }

    public JsonPrimitive(Character c) {
        this.value = $Gson$Preconditions.checkNotNull(c).toString();
    }

    public JsonPrimitive(Number number) {
        this.value = $Gson$Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(String string) {
        this.value = $Gson$Preconditions.checkNotNull(string);
    }

    private static boolean isIntegral(JsonPrimitive object) {
        boolean bl;
        object = ((JsonPrimitive)object).value;
        boolean bl2 = object instanceof Number;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        if (!((object = (Number)object) instanceof BigInteger || object instanceof Long || object instanceof Integer || object instanceof Short)) {
            bl3 = bl;
            if (!(object instanceof Byte)) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    @Override
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (JsonPrimitive)object;
        if (this.value == null) {
            bl = ((JsonPrimitive)object).value == null ? bl3 : false;
            return bl;
        }
        if (JsonPrimitive.isIntegral(this) && JsonPrimitive.isIntegral((JsonPrimitive)object)) {
            if (this.getAsNumber().longValue() == ((JsonPrimitive)object).getAsNumber().longValue()) return bl;
            bl = false;
            return bl;
        }
        if (!(this.value instanceof Number)) return this.value.equals(((JsonPrimitive)object).value);
        if (!(((JsonPrimitive)object).value instanceof Number)) return this.value.equals(((JsonPrimitive)object).value);
        double d = this.getAsNumber().doubleValue();
        double d2 = ((JsonPrimitive)object).getAsNumber().doubleValue();
        bl = bl2;
        if (d == d2) return bl;
        bl = Double.isNaN(d) && Double.isNaN(d2) ? bl2 : false;
        return bl;
    }

    @Override
    public BigDecimal getAsBigDecimal() {
        Object object = this.value;
        object = object instanceof BigDecimal ? (BigDecimal)object : new BigDecimal(this.value.toString());
        return object;
    }

    @Override
    public BigInteger getAsBigInteger() {
        Object object = this.value;
        object = object instanceof BigInteger ? (BigInteger)object : new BigInteger(this.value.toString());
        return object;
    }

    @Override
    public boolean getAsBoolean() {
        if (!this.isBoolean()) return Boolean.parseBoolean(this.getAsString());
        return (Boolean)this.value;
    }

    @Override
    public byte getAsByte() {
        byte by = this.isNumber() ? this.getAsNumber().byteValue() : Byte.parseByte(this.getAsString());
        return by;
    }

    @Override
    public char getAsCharacter() {
        return this.getAsString().charAt(0);
    }

    @Override
    public double getAsDouble() {
        double d = this.isNumber() ? this.getAsNumber().doubleValue() : Double.parseDouble(this.getAsString());
        return d;
    }

    @Override
    public float getAsFloat() {
        float f = this.isNumber() ? this.getAsNumber().floatValue() : Float.parseFloat(this.getAsString());
        return f;
    }

    @Override
    public int getAsInt() {
        int n = this.isNumber() ? this.getAsNumber().intValue() : Integer.parseInt(this.getAsString());
        return n;
    }

    @Override
    public long getAsLong() {
        long l = this.isNumber() ? this.getAsNumber().longValue() : Long.parseLong(this.getAsString());
        return l;
    }

    @Override
    public Number getAsNumber() {
        Object object = this.value;
        object = object instanceof String ? new LazilyParsedNumber((String)this.value) : (Number)object;
        return object;
    }

    @Override
    public short getAsShort() {
        short s = this.isNumber() ? this.getAsNumber().shortValue() : Short.parseShort(this.getAsString());
        return s;
    }

    @Override
    public String getAsString() {
        if (this.isNumber()) {
            return this.getAsNumber().toString();
        }
        if (!this.isBoolean()) return (String)this.value;
        return ((Boolean)this.value).toString();
    }

    public int hashCode() {
        long l;
        if (this.value == null) {
            return 31;
        }
        if (JsonPrimitive.isIntegral(this)) {
            l = this.getAsNumber().longValue();
        } else {
            Object object = this.value;
            if (!(object instanceof Number)) return object.hashCode();
            l = Double.doubleToLongBits(this.getAsNumber().doubleValue());
        }
        return (int)(l >>> 32 ^ l);
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }
}
