/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzgjd;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzggk {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzgfc zze;

    static {
        byte[] byArray = new byte[]{};
        zzc = byArray;
        zzd = ByteBuffer.wrap(byArray);
        byArray = zzc;
        int n = zzgfc.zzd;
        n = byArray.length;
        zze = zzgfc.zzF((byte[])byArray, (int)0, (int)0, (boolean)false);
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
        return zzgjd.zza((byte[])byArray);
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
        n2 = n = zzggk.zzh(n2, byArray, 0, n2);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }

    static int zzh(int n, byte[] byArray, int n2, int n3) {
        int n4 = n2;
        int n5 = n;
        n = n4;
        while (n < n2 + n3) {
            n5 = n5 * 31 + byArray[n];
            ++n;
        }
        return n5;
    }

    static Object zzi(Object object, Object object2) {
        return ((zzghi)object).zzaL().zzad((zzghi)object2).zzak();
    }
}
