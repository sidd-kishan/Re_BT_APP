/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 */
package androidx.work;

import androidx.work.Data;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class Data.Builder {
    private Map<String, Object> mValues = new HashMap<String, Object>();

    public Data build() {
        Data data = new Data(this.mValues);
        Data.toByteArrayInternal((Data)data);
        return data;
    }

    public Data.Builder put(String string, Object object) {
        if (object == null) {
            this.mValues.put(string, null);
        } else {
            Class<?> clazz = object.getClass();
            if (clazz != Boolean.class && clazz != Byte.class && clazz != Integer.class && clazz != Long.class && clazz != Float.class && clazz != Double.class && clazz != String.class && clazz != Boolean[].class && clazz != Byte[].class && clazz != Integer[].class && clazz != Long[].class && clazz != Float[].class && clazz != Double[].class && clazz != String[].class) {
                if (clazz == boolean[].class) {
                    this.mValues.put(string, Data.convertPrimitiveBooleanArray((boolean[])((boolean[])object)));
                } else if (clazz == byte[].class) {
                    this.mValues.put(string, Data.convertPrimitiveByteArray((byte[])((byte[])object)));
                } else if (clazz == int[].class) {
                    this.mValues.put(string, Data.convertPrimitiveIntArray((int[])((int[])object)));
                } else if (clazz == long[].class) {
                    this.mValues.put(string, Data.convertPrimitiveLongArray((long[])((long[])object)));
                } else if (clazz == float[].class) {
                    this.mValues.put(string, Data.convertPrimitiveFloatArray((float[])((float[])object)));
                } else {
                    if (clazz != double[].class) {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", string, clazz));
                    }
                    this.mValues.put(string, Data.convertPrimitiveDoubleArray((double[])((double[])object)));
                }
            } else {
                this.mValues.put(string, object);
            }
        }
        return this;
    }

    public Data.Builder putAll(Data data) {
        this.putAll(data.mValues);
        return this;
    }

    public Data.Builder putAll(Map<String, Object> object) {
        Iterator<Map.Entry<String, Object>> iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            this.put((String)object.getKey(), object.getValue());
        }
        return this;
    }

    public Data.Builder putBoolean(String string, boolean bl) {
        this.mValues.put(string, bl);
        return this;
    }

    public Data.Builder putBooleanArray(String string, boolean[] blArray) {
        this.mValues.put(string, Data.convertPrimitiveBooleanArray((boolean[])blArray));
        return this;
    }

    public Data.Builder putByte(String string, byte by) {
        this.mValues.put(string, by);
        return this;
    }

    public Data.Builder putByteArray(String string, byte[] byArray) {
        this.mValues.put(string, Data.convertPrimitiveByteArray((byte[])byArray));
        return this;
    }

    public Data.Builder putDouble(String string, double d) {
        this.mValues.put(string, d);
        return this;
    }

    public Data.Builder putDoubleArray(String string, double[] dArray) {
        this.mValues.put(string, Data.convertPrimitiveDoubleArray((double[])dArray));
        return this;
    }

    public Data.Builder putFloat(String string, float f) {
        this.mValues.put(string, Float.valueOf(f));
        return this;
    }

    public Data.Builder putFloatArray(String string, float[] fArray) {
        this.mValues.put(string, Data.convertPrimitiveFloatArray((float[])fArray));
        return this;
    }

    public Data.Builder putInt(String string, int n) {
        this.mValues.put(string, n);
        return this;
    }

    public Data.Builder putIntArray(String string, int[] nArray) {
        this.mValues.put(string, Data.convertPrimitiveIntArray((int[])nArray));
        return this;
    }

    public Data.Builder putLong(String string, long l) {
        this.mValues.put(string, l);
        return this;
    }

    public Data.Builder putLongArray(String string, long[] lArray) {
        this.mValues.put(string, Data.convertPrimitiveLongArray((long[])lArray));
        return this;
    }

    public Data.Builder putString(String string, String string2) {
        this.mValues.put(string, string2);
        return this;
    }

    public Data.Builder putStringArray(String string, String[] stringArray) {
        this.mValues.put(string, stringArray);
        return this;
    }
}
