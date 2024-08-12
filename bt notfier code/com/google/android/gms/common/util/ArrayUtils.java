/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Objects
 */
package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> T[] appendToArray(T[] objectArray, T t) {
        if (objectArray == null) {
            if (t == null) throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        objectArray = objectArray == null ? (Object[])Array.newInstance(t.getClass(), 1) : Arrays.copyOf(objectArray, objectArray.length + 1);
        objectArray[objectArray.length - 1] = t;
        return objectArray;
    }

    public static <T> T[] concat(T[] ... TArray) {
        int n;
        if (TArray.length == 0) return (Object[])Array.newInstance(TArray.getClass(), 0);
        int n2 = 0;
        for (n = 0; n < TArray.length; n2 += TArray[n].length, ++n) {
        }
        T[] TArray2 = Arrays.copyOf(TArray[0], n2);
        n = TArray[0].length;
        n2 = 1;
        while (n2 < TArray.length) {
            T[] TArray3 = TArray[n2];
            int n3 = TArray3.length;
            System.arraycopy(TArray3, 0, TArray2, n, n3);
            n += n3;
            ++n2;
        }
        return TArray2;
    }

    public static byte[] concatByteArrays(byte[] ... byArray) {
        int n;
        if (byArray.length == 0) return new byte[0];
        int n2 = 0;
        for (n = 0; n < byArray.length; n2 += byArray[n].length, ++n) {
        }
        byte[] byArray2 = Arrays.copyOf(byArray[0], n2);
        n = byArray[0].length;
        n2 = 1;
        while (n2 < byArray.length) {
            byte[] byArray3 = byArray[n2];
            int n3 = byArray3.length;
            System.arraycopy(byArray3, 0, byArray2, n, n3);
            n += n3;
            ++n2;
        }
        return byArray2;
    }

    public static boolean contains(int[] nArray, int n) {
        if (nArray == null) {
            return false;
        }
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (nArray[n3] == n) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static <T> boolean contains(T[] TArray, T t) {
        int n = TArray != null ? TArray.length : 0;
        int n2 = 0;
        while (n2 < n) {
            if (Objects.equal(TArray[n2], t)) {
                if (n2 < 0) return false;
                return true;
            }
            ++n2;
        }
        return false;
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> T[] removeAll(T[] objectArray, T ... TArray) {
        int n;
        int n2;
        Object var6_2 = null;
        if (objectArray == null) {
            return null;
        }
        if (TArray == null) return Arrays.copyOf(objectArray, objectArray.length);
        int n3 = TArray.length;
        if (n3 == 0) {
            return Arrays.copyOf(objectArray, objectArray.length);
        }
        Object[] objectArray2 = TArray.getClass().getComponentType();
        int n4 = objectArray.length;
        objectArray2 = (Object[])Array.newInstance(objectArray2, n4);
        if (n3 == 1) {
            n2 = 0;
            n3 = 0;
            while (true) {
                n = n3;
                if (n2 < n4) {
                    T t = objectArray[n2];
                    n = n3;
                    if (!Objects.equal(TArray[0], t)) {
                        objectArray2[n3] = t;
                        n = n3 + 1;
                    }
                    ++n2;
                    n3 = n;
                    continue;
                }
                break;
            }
        } else {
            n3 = 0;
            for (n2 = 0; n2 < n4; ++n2) {
                T t = objectArray[n2];
                n = n3;
                if (!ArrayUtils.contains(TArray, t)) {
                    objectArray2[n3] = t;
                    n = n3 + 1;
                }
                n3 = n;
            }
            n = n3;
        }
        if (objectArray2 == null) {
            objectArray = var6_2;
        } else {
            if (n != objectArray2.length) return Arrays.copyOf(objectArray2, n);
            objectArray = objectArray2;
        }
        return objectArray;
    }

    public static <T> ArrayList<T> toArrayList(T[] TArray) {
        int n = TArray.length;
        ArrayList<T> arrayList = new ArrayList<T>(n);
        int n2 = 0;
        while (n2 < n) {
            arrayList.add(TArray[n2]);
            ++n2;
        }
        return arrayList;
    }

    public static int[] toPrimitiveArray(Collection<Integer> object) {
        int n = 0;
        if (object == null) return new int[0];
        if (object.size() == 0) {
            return new int[0];
        }
        int[] nArray = new int[object.size()];
        object = object.iterator();
        while (object.hasNext()) {
            nArray[n] = (Integer)object.next();
            ++n;
        }
        return nArray;
    }

    public static Integer[] toWrapperArray(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        int n = nArray.length;
        Integer[] integerArray = new Integer[n];
        int n2 = 0;
        while (n2 < n) {
            integerArray[n2] = nArray[n2];
            ++n2;
        }
        return integerArray;
    }

    public static void writeArray(StringBuilder stringBuilder, double[] dArray) {
        int n = dArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArray[n2]));
            ++n2;
        }
    }

    public static void writeArray(StringBuilder stringBuilder, float[] fArray) {
        int n = fArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArray[n2]));
            ++n2;
        }
    }

    public static void writeArray(StringBuilder stringBuilder, int[] nArray) {
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toString(nArray[n2]));
            ++n2;
        }
    }

    public static void writeArray(StringBuilder stringBuilder, long[] lArray) {
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(lArray[n2]));
            ++n2;
        }
    }

    public static <T> void writeArray(StringBuilder stringBuilder, T[] TArray) {
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(TArray[n2]);
            ++n2;
        }
    }

    public static void writeArray(StringBuilder stringBuilder, boolean[] blArray) {
        int n = blArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(blArray[n2]));
            ++n2;
        }
    }

    public static void writeStringArray(StringBuilder stringBuilder, String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"");
            stringBuilder.append(stringArray[n2]);
            stringBuilder.append("\"");
            ++n2;
        }
    }
}
