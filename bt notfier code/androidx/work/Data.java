/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.work.Data$Builder
 *  androidx.work.Logger
 */
package androidx.work;

import android.util.Log;
import androidx.work.Data;
import androidx.work.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY;
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG;
    Map<String, Object> mValues;

    static {
        TAG = Logger.tagWithPrefix((String)"Data");
        EMPTY = new Builder().build();
    }

    Data() {
    }

    public Data(Data data) {
        this.mValues = new HashMap<String, Object>(data.mValues);
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] blArray) {
        Boolean[] booleanArray = new Boolean[blArray.length];
        int n = 0;
        while (n < blArray.length) {
            booleanArray[n] = blArray[n];
            ++n;
        }
        return booleanArray;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] byArray) {
        Byte[] byteArray = new Byte[byArray.length];
        int n = 0;
        while (n < byArray.length) {
            byteArray[n] = byArray[n];
            ++n;
        }
        return byteArray;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArray) {
        Double[] doubleArray = new Double[dArray.length];
        int n = 0;
        while (n < dArray.length) {
            doubleArray[n] = dArray[n];
            ++n;
        }
        return doubleArray;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArray) {
        Float[] floatArray = new Float[fArray.length];
        int n = 0;
        while (n < fArray.length) {
            floatArray[n] = Float.valueOf(fArray[n]);
            ++n;
        }
        return floatArray;
    }

    public static Integer[] convertPrimitiveIntArray(int[] nArray) {
        Integer[] integerArray = new Integer[nArray.length];
        int n = 0;
        while (n < nArray.length) {
            integerArray[n] = nArray[n];
            ++n;
        }
        return integerArray;
    }

    public static Long[] convertPrimitiveLongArray(long[] lArray) {
        Long[] longArray = new Long[lArray.length];
        int n = 0;
        while (n < lArray.length) {
            longArray[n] = lArray[n];
            ++n;
        }
        return longArray;
    }

    public static byte[] convertToPrimitiveArray(Byte[] byteArray) {
        byte[] byArray = new byte[byteArray.length];
        int n = 0;
        while (n < byteArray.length) {
            byArray[n] = byteArray[n];
            ++n;
        }
        return byArray;
    }

    public static double[] convertToPrimitiveArray(Double[] doubleArray) {
        double[] dArray = new double[doubleArray.length];
        int n = 0;
        while (n < doubleArray.length) {
            dArray[n] = doubleArray[n];
            ++n;
        }
        return dArray;
    }

    public static float[] convertToPrimitiveArray(Float[] floatArray) {
        float[] fArray = new float[floatArray.length];
        int n = 0;
        while (n < floatArray.length) {
            fArray[n] = floatArray[n].floatValue();
            ++n;
        }
        return fArray;
    }

    public static int[] convertToPrimitiveArray(Integer[] integerArray) {
        int[] nArray = new int[integerArray.length];
        int n = 0;
        while (n < integerArray.length) {
            nArray[n] = integerArray[n];
            ++n;
        }
        return nArray;
    }

    public static long[] convertToPrimitiveArray(Long[] longArray) {
        long[] lArray = new long[longArray.length];
        int n = 0;
        while (n < longArray.length) {
            lArray[n] = longArray[n];
            ++n;
        }
        return lArray;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] booleanArray) {
        boolean[] blArray = new boolean[booleanArray.length];
        int n = 0;
        while (n < booleanArray.length) {
            blArray[n] = booleanArray[n];
            ++n;
        }
        return blArray;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static Data fromByteArray(byte[] object) {
        void var2_13;
        ByteArrayInputStream byteArrayInputStream;
        block24: {
            HashMap<String, Object> hashMap;
            block25: {
                void var3_18;
                ObjectInputStream objectInputStream;
                block23: {
                    if (((Object)object).length > 10240) {
                        object = new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                        throw object;
                    }
                    hashMap = new HashMap<String, Object>();
                    byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    object = objectInputStream;
                    for (int i = objectInputStream.readInt(); i > 0; --i) {
                        object = objectInputStream;
                        hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                    }
                    try {
                        objectInputStream.close();
                    }
                    catch (IOException iOException) {
                        Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)iOException);
                    }
                    byteArrayInputStream.close();
                    return new Data(hashMap);
                    catch (ClassNotFoundException classNotFoundException) {
                        break block23;
                    }
                    catch (IOException iOException) {
                        break block23;
                    }
                    catch (Throwable throwable) {
                        object = null;
                        break block24;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                    objectInputStream = null;
                    Object object2 = object;
                }
                object = objectInputStream;
                Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var3_18);
                if (objectInputStream == null) break block25;
                try {
                    objectInputStream.close();
                }
                catch (IOException iOException) {
                    Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)iOException);
                }
            }
            try {
                byteArrayInputStream.close();
                return new Data(hashMap);
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)iOException);
            }
            return new Data(hashMap);
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            try {
                ((ObjectInputStream)object).close();
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)iOException);
            }
        }
        try {
            byteArrayInputStream.close();
            throw var2_13;
        }
        catch (IOException iOException) {
            Log.e((String)TAG, (String)"Error in Data#fromByteArray: ", (Throwable)iOException);
        }
        throw var2_13;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static byte[] toByteArrayInternal(Data entry2) {
        void var0_7;
        Iterator<Map.Entry<String, Object>> iterator;
        ByteArrayOutputStream byteArrayOutputStream;
        block21: {
            Object object;
            block23: {
                block22: {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    Object var3_9 = null;
                    Data data = null;
                    iterator = data;
                    try {
                        iterator = data;
                        object = new ObjectOutputStream(byteArrayOutputStream);
                    }
                    catch (Throwable throwable) {
                        break block21;
                    }
                    catch (IOException iOException) {
                        entry2 = var3_9;
                        break block22;
                    }
                    try {
                        ((ObjectOutputStream)object).writeInt(((Data)((Object)entry2)).size());
                        for (Map.Entry<String, Object> entry2 : ((Data)((Object)entry2)).mValues.entrySet()) {
                            ((ObjectOutputStream)object).writeUTF(entry2.getKey());
                            ((ObjectOutputStream)object).writeObject(entry2.getValue());
                        }
                    }
                    catch (Throwable throwable) {
                        iterator = object;
                        break block21;
                    }
                    catch (IOException iOException) {
                        entry2 = object;
                        object = iOException;
                        break block22;
                    }
                    try {
                        ((ObjectOutputStream)object).close();
                    }
                    catch (IOException iOException) {
                        Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                    }
                    try {
                        byteArrayOutputStream.close();
                    }
                    catch (IOException iOException) {
                        Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                    }
                    if (byteArrayOutputStream.size() > 10240) throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    return byteArrayOutputStream.toByteArray();
                }
                iterator = entry2;
                {
                    Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)object);
                    iterator = entry2;
                    object = byteArrayOutputStream.toByteArray();
                    if (entry2 == null) break block23;
                }
                try {
                    ((ObjectOutputStream)((Object)entry2)).close();
                }
                catch (IOException iOException) {
                    Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                }
            }
            try {
                byteArrayOutputStream.close();
                return object;
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            }
            return object;
        }
        if (iterator != null) {
            try {
                ((ObjectOutputStream)((Object)iterator)).close();
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            }
        }
        try {
            byteArrayOutputStream.close();
            throw var0_7;
        }
        catch (IOException iOException) {
            Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            throw var0_7;
        }
    }

    public boolean equals(Object object) {
        boolean bl;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (Data)object;
        Set<String> set = this.mValues.keySet();
        if (!set.equals(((Data)object).mValues.keySet())) {
            return false;
        }
        set = set.iterator();
        do {
            if (!set.hasNext()) return true;
            Object object2 = (String)set.next();
            Object object3 = this.mValues.get(object2);
            object2 = ((Data)object).mValues.get(object2);
            if (object3 != null && object2 != null) {
                if (object3 instanceof Object[] && object2 instanceof Object[]) {
                    bl = Arrays.deepEquals((Object[])object3, (Object[])object2);
                    continue;
                }
                bl = object3.equals(object2);
                continue;
            }
            bl = object3 == object2;
        } while (bl);
        return false;
    }

    public boolean getBoolean(String object, boolean bl) {
        if (!((object = this.mValues.get(object)) instanceof Boolean)) return bl;
        return (Boolean)object;
    }

    public boolean[] getBooleanArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Boolean[])) return null;
        return Data.convertToPrimitiveArray((Boolean[])object);
    }

    public byte getByte(String object, byte by) {
        if (!((object = this.mValues.get(object)) instanceof Byte)) return by;
        return (Byte)object;
    }

    public byte[] getByteArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Byte[])) return null;
        return Data.convertToPrimitiveArray((Byte[])object);
    }

    public double getDouble(String object, double d) {
        if (!((object = this.mValues.get(object)) instanceof Double)) return d;
        return (Double)object;
    }

    public double[] getDoubleArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Double[])) return null;
        return Data.convertToPrimitiveArray((Double[])object);
    }

    public float getFloat(String object, float f) {
        if (!((object = this.mValues.get(object)) instanceof Float)) return f;
        return ((Float)object).floatValue();
    }

    public float[] getFloatArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Float[])) return null;
        return Data.convertToPrimitiveArray((Float[])object);
    }

    public int getInt(String object, int n) {
        if (!((object = this.mValues.get(object)) instanceof Integer)) return n;
        return (Integer)object;
    }

    public int[] getIntArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Integer[])) return null;
        return Data.convertToPrimitiveArray((Integer[])object);
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(String object, long l) {
        if (!((object = this.mValues.get(object)) instanceof Long)) return l;
        return (Long)object;
    }

    public long[] getLongArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof Long[])) return null;
        return Data.convertToPrimitiveArray((Long[])object);
    }

    public String getString(String object) {
        if (!((object = this.mValues.get(object)) instanceof String)) return null;
        return (String)object;
    }

    public String[] getStringArray(String object) {
        if (!((object = this.mValues.get(object)) instanceof String[])) return null;
        return (String[])object;
    }

    public <T> boolean hasKeyWithValueOfType(String object, Class<T> clazz) {
        boolean bl = (object = this.mValues.get(object)) != null && clazz.isAssignableFrom(object.getClass());
        return bl;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public int size() {
        return this.mValues.size();
    }

    public byte[] toByteArray() {
        return Data.toByteArrayInternal(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String string : this.mValues.keySet()) {
                stringBuilder.append(string);
                stringBuilder.append(" : ");
                Object object = this.mValues.get(string);
                if (object instanceof Object[]) {
                    stringBuilder.append(Arrays.toString((Object[])object));
                } else {
                    stringBuilder.append(object);
                }
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
