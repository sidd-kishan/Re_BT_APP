/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 *  android.util.SparseLongArray
 */
package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        return SafeParcelWriter.zzb(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int n) {
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeBigDecimal(Parcel parcel, int n, BigDecimal bigDecimal, boolean bl) {
        if (bigDecimal == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeBigDecimalArray(Parcel parcel, int n, BigDecimal[] bigDecimalArray, boolean bl) {
        int n2 = 0;
        if (bigDecimalArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = bigDecimalArray.length;
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeByteArray(bigDecimalArray[n].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArray[n].scale());
            ++n;
        }
    }

    public static void writeBigInteger(Parcel parcel, int n, BigInteger bigInteger, boolean bl) {
        if (bigInteger == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeByteArray(bigInteger.toByteArray());
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeBigIntegerArray(Parcel parcel, int n, BigInteger[] bigIntegerArray, boolean bl) {
        int n2 = 0;
        if (bigIntegerArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = bigIntegerArray.length;
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeByteArray(bigIntegerArray[n].toByteArray());
            ++n;
        }
    }

    public static void writeBoolean(Parcel parcel, int n, boolean bl) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt(bl ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int n, boolean[] blArray, boolean bl) {
        if (blArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeBooleanArray(blArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeBooleanList(Parcel parcel, int n, List<Boolean> list, boolean bl) {
        int n2 = 0;
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = list.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(list.get(n).booleanValue() ? 1 : 0);
            ++n;
        }
    }

    public static void writeBooleanObject(Parcel parcel, int n, Boolean bl, boolean bl2) {
        if (bl == null) {
            if (!bl2) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt(bl.booleanValue() ? 1 : 0);
    }

    public static void writeBundle(Parcel parcel, int n, Bundle bundle, boolean bl) {
        if (bundle == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeBundle(bundle);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeByte(Parcel parcel, int n, byte by) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt((int)by);
    }

    public static void writeByteArray(Parcel parcel, int n, byte[] byArray, boolean bl) {
        if (byArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeByteArray(byArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeByteArrayArray(Parcel parcel, int n, byte[][] byArray, boolean bl) {
        int n2 = 0;
        if (byArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = byArray.length;
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeByteArray(byArray[n]);
            ++n;
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int n, SparseArray<byte[]> sparseArray, boolean bl) {
        int n2 = 0;
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            parcel.writeByteArray((byte[])sparseArray.valueAt(n));
            ++n;
        }
    }

    public static void writeChar(Parcel parcel, int n, char c) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt((int)c);
    }

    public static void writeCharArray(Parcel parcel, int n, char[] cArray, boolean bl) {
        if (cArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeCharArray(cArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeDouble(Parcel parcel, int n, double d) {
        SafeParcelWriter.zza(parcel, n, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(Parcel parcel, int n, double[] dArray, boolean bl) {
        if (dArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeDoubleArray(dArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeDoubleList(Parcel parcel, int n, List<Double> list, boolean bl) {
        int n2 = 0;
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = list.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeDouble(list.get(n).doubleValue());
            ++n;
        }
    }

    public static void writeDoubleObject(Parcel parcel, int n, Double d, boolean bl) {
        if (d == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        SafeParcelWriter.zza(parcel, n, 8);
        parcel.writeDouble(d.doubleValue());
    }

    public static void writeDoubleSparseArray(Parcel parcel, int n, SparseArray<Double> sparseArray, boolean bl) {
        int n2 = 0;
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            parcel.writeDouble(((Double)sparseArray.valueAt(n)).doubleValue());
            ++n;
        }
    }

    public static void writeFloat(Parcel parcel, int n, float f) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(Parcel parcel, int n, float[] fArray, boolean bl) {
        if (fArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeFloatArray(fArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeFloatList(Parcel parcel, int n, List<Float> list, boolean bl) {
        int n2 = 0;
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = list.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeFloat(list.get(n).floatValue());
            ++n;
        }
    }

    public static void writeFloatObject(Parcel parcel, int n, Float f, boolean bl) {
        if (f == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeFloat(f.floatValue());
    }

    public static void writeFloatSparseArray(Parcel parcel, int n, SparseArray<Float> sparseArray, boolean bl) {
        int n2 = 0;
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            parcel.writeFloat(((Float)sparseArray.valueAt(n)).floatValue());
            ++n;
        }
    }

    public static void writeIBinder(Parcel parcel, int n, IBinder iBinder, boolean bl) {
        if (iBinder == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeStrongBinder(iBinder);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeIBinderArray(Parcel parcel, int n, IBinder[] iBinderArray, boolean bl) {
        if (iBinderArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeBinderArray(iBinderArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeIBinderList(Parcel parcel, int n, List<IBinder> list, boolean bl) {
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeBinderList(list);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeIBinderSparseArray(Parcel parcel, int n, SparseArray<IBinder> sparseArray, boolean bl) {
        int n2 = 0;
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            parcel.writeStrongBinder((IBinder)sparseArray.valueAt(n));
            ++n;
        }
    }

    public static void writeInt(Parcel parcel, int n, int n2) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt(n2);
    }

    public static void writeIntArray(Parcel parcel, int n, int[] nArray, boolean bl) {
        if (nArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeIntArray(nArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeIntegerList(Parcel parcel, int n, List<Integer> list, boolean bl) {
        int n2 = 0;
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = list.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(list.get(n).intValue());
            ++n;
        }
    }

    public static void writeIntegerObject(Parcel parcel, int n, Integer n2, boolean bl) {
        if (n2 == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt(n2.intValue());
    }

    public static void writeList(Parcel parcel, int n, List list, boolean bl) {
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeList(list);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeLong(Parcel parcel, int n, long l) {
        SafeParcelWriter.zza(parcel, n, 8);
        parcel.writeLong(l);
    }

    public static void writeLongArray(Parcel parcel, int n, long[] lArray, boolean bl) {
        if (lArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeLongArray(lArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeLongList(Parcel parcel, int n, List<Long> list, boolean bl) {
        int n2 = 0;
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = list.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeLong(list.get(n).longValue());
            ++n;
        }
    }

    public static void writeLongObject(Parcel parcel, int n, Long l, boolean bl) {
        if (l == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        SafeParcelWriter.zza(parcel, n, 8);
        parcel.writeLong(l.longValue());
    }

    public static void writeParcel(Parcel parcel, int n, Parcel parcel2, boolean bl) {
        if (parcel2 == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeParcelArray(Parcel parcel, int n, Parcel[] parcelArray, boolean bl) {
        if (parcelArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n2 = SafeParcelWriter.zzb(parcel, n);
        int n3 = parcelArray.length;
        parcel.writeInt(n3);
        n = 0;
        while (true) {
            if (n >= n3) {
                SafeParcelWriter.zzc(parcel, n2);
                return;
            }
            Parcel parcel2 = parcelArray[n];
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
            ++n;
        }
    }

    public static void writeParcelList(Parcel parcel, int n, List<Parcel> list, boolean bl) {
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n2 = SafeParcelWriter.zzb(parcel, n);
        int n3 = list.size();
        parcel.writeInt(n3);
        n = 0;
        while (true) {
            if (n >= n3) {
                SafeParcelWriter.zzc(parcel, n2);
                return;
            }
            Parcel parcel2 = list.get(n);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
            ++n;
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int n, SparseArray<Parcel> sparseArray, boolean bl) {
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n2 = SafeParcelWriter.zzb(parcel, n);
        int n3 = sparseArray.size();
        parcel.writeInt(n3);
        n = 0;
        while (true) {
            if (n >= n3) {
                SafeParcelWriter.zzc(parcel, n2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            Parcel parcel2 = (Parcel)sparseArray.valueAt(n);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
            ++n;
        }
    }

    public static void writeParcelable(Parcel parcel, int n, Parcelable parcelable, int n2, boolean bl) {
        if (parcelable == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcelable.writeToParcel(parcel, n2);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writePendingIntent(Parcel parcel, int n, PendingIntent pendingIntent, boolean bl) {
        if (pendingIntent == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        PendingIntent.writePendingIntentOrNullToParcel((PendingIntent)pendingIntent, (Parcel)parcel);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeShort(Parcel parcel, int n, short s) {
        SafeParcelWriter.zza(parcel, n, 4);
        parcel.writeInt((int)s);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int n, SparseBooleanArray sparseBooleanArray, boolean bl) {
        if (sparseBooleanArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeSparseIntArray(Parcel parcel, int n, SparseIntArray sparseIntArray, boolean bl) {
        int n2 = 0;
        if (sparseIntArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseIntArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseIntArray.keyAt(n));
            parcel.writeInt(sparseIntArray.valueAt(n));
            ++n;
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int n, SparseLongArray sparseLongArray, boolean bl) {
        int n2 = 0;
        if (sparseLongArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseLongArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseLongArray.keyAt(n));
            parcel.writeLong(sparseLongArray.valueAt(n));
            ++n;
        }
    }

    public static void writeString(Parcel parcel, int n, String string, boolean bl) {
        if (string == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeString(string);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeStringArray(Parcel parcel, int n, String[] stringArray, boolean bl) {
        if (stringArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeStringArray(stringArray);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeStringList(Parcel parcel, int n, List<String> list, boolean bl) {
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        n = SafeParcelWriter.zzb(parcel, n);
        parcel.writeStringList(list);
        SafeParcelWriter.zzc(parcel, n);
    }

    public static void writeStringSparseArray(Parcel parcel, int n, SparseArray<String> sparseArray, boolean bl) {
        int n2 = 0;
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = sparseArray.size();
        parcel.writeInt(n4);
        n = n2;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            parcel.writeString((String)sparseArray.valueAt(n));
            ++n;
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int n, T[] TArray, int n2, boolean bl) {
        if (TArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n3 = SafeParcelWriter.zzb(parcel, n);
        int n4 = TArray.length;
        parcel.writeInt(n4);
        n = 0;
        while (true) {
            if (n >= n4) {
                SafeParcelWriter.zzc(parcel, n3);
                return;
            }
            T t = TArray[n];
            if (t == null) {
                parcel.writeInt(0);
            } else {
                SafeParcelWriter.zzd(parcel, t, n2);
            }
            ++n;
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int n, List<T> list, boolean bl) {
        if (list == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n2 = SafeParcelWriter.zzb(parcel, n);
        int n3 = list.size();
        parcel.writeInt(n3);
        n = 0;
        while (true) {
            if (n >= n3) {
                SafeParcelWriter.zzc(parcel, n2);
                return;
            }
            Parcelable parcelable = (Parcelable)list.get(n);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                SafeParcelWriter.zzd(parcel, parcelable, 0);
            }
            ++n;
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int n, SparseArray<T> sparseArray, boolean bl) {
        if (sparseArray == null) {
            if (!bl) return;
            SafeParcelWriter.zza(parcel, n, 0);
            return;
        }
        int n2 = SafeParcelWriter.zzb(parcel, n);
        int n3 = sparseArray.size();
        parcel.writeInt(n3);
        n = 0;
        while (true) {
            if (n >= n3) {
                SafeParcelWriter.zzc(parcel, n2);
                return;
            }
            parcel.writeInt(sparseArray.keyAt(n));
            Parcelable parcelable = (Parcelable)sparseArray.valueAt(n);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                SafeParcelWriter.zzd(parcel, parcelable, 0);
            }
            ++n;
        }
    }

    private static void zza(Parcel parcel, int n, int n2) {
        parcel.writeInt(n | n2 << 16);
    }

    private static int zzb(Parcel parcel, int n) {
        parcel.writeInt(n | 0xFFFF0000);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int n) {
        int n2 = parcel.dataPosition();
        parcel.setDataPosition(n - 4);
        parcel.writeInt(n2 - n);
        parcel.setDataPosition(n2);
    }

    private static <T extends Parcelable> void zzd(Parcel parcel, T t, int n) {
        int n2 = parcel.dataPosition();
        parcel.writeInt(1);
        int n3 = parcel.dataPosition();
        t.writeToParcel(parcel, n);
        n = parcel.dataPosition();
        parcel.setDataPosition(n2);
        parcel.writeInt(n - n3);
        parcel.setDataPosition(n);
    }
}
