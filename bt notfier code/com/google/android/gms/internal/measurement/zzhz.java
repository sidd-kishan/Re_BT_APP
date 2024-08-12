/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgt
 *  com.google.android.gms.internal.measurement.zzgu
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzgu;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzkk;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzhz {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzgu zze;

    static {
        Object object = new byte[]{};
        zzc = object;
        zzd = ByteBuffer.wrap(object);
        object = zzc;
        int n = ((byte[])object).length;
        object = new zzgt(object, 0, 0, false, null);
        try {
            object.zza(0);
        }
        catch (zzib zzib2) {
            throw new IllegalArgumentException(zzib2);
        }
        zze = (zzgu)object;
    }

    static <T> T zza(T t) {
        if (t == null) throw null;
        return t;
    }

    static <T> T zzb(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }

    public static boolean zzc(byte[] byArray) {
        return zzkk.zza((byte[])byArray);
    }

    public static String zzd(byte[] byArray) {
        return new String(byArray, zza);
    }

    public static int zze(long l) {
        return (int)(l ^ l >>> 32);
    }

    public static int zzf(boolean bl) {
        if (!bl) return 1237;
        return 1231;
    }

    public static int zzg(byte[] byArray) {
        int n;
        int n2 = byArray.length;
        n2 = n = zzhz.zzh(n2, byArray, 0, n2);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    static int zzh(int n, byte[] byArray, int n2, int n3) {
        n2 = 0;
        while (n2 < n3) {
            n = n * 31 + byArray[n2];
            ++n2;
        }
        return n;
    }

    static Object zzi(Object object, Object object2) {
        return ((zziw)object).zzbG().zzau((zziw)object2).zzaD();
    }
}
