/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgc
 *  com.google.android.gms.internal.measurement.zzgi
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgv
 *  com.google.android.gms.internal.measurement.zzgw
 *  com.google.android.gms.internal.measurement.zzgx
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzie
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzkf
 *  com.google.android.gms.internal.measurement.zzkj
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzgw;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkk;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgy
extends zzgi {
    private static final Logger zzb = Logger.getLogger(zzgy.class.getName());
    private static final boolean zzc = zzkf.zza();
    zzgz zza;

    private zzgy() {
    }

    /* synthetic */ zzgy(zzgv zzgv2) {
    }

    public static int zzA(zzgr zzgr2) {
        int n = zzgr2.zzc();
        return zzgy.zzw(n) + n;
    }

    static int zzB(zziw zziw2, zzjh zzjh2) {
        int n;
        zziw2 = (zzgc)zziw2;
        int n2 = n = zziw2.zzbq();
        if (n != -1) return zzgy.zzw(n2) + n2;
        n2 = zzjh2.zze((Object)zziw2);
        zziw2.zzbr(n2);
        return zzgy.zzw(n2) + n2;
    }

    @Deprecated
    static int zzE(int n, zziw zziw2, zzjh zzjh2) {
        int n2;
        int n3 = zzgy.zzw(n << 3);
        zziw2 = (zzgc)zziw2;
        n = n2 = zziw2.zzbq();
        if (n2 != -1) return n3 + n3 + n;
        n = zzjh2.zze((Object)zziw2);
        zziw2.zzbr(n);
        return n3 + n3 + n;
    }

    static /* synthetic */ boolean zzF() {
        return zzc;
    }

    public static zzgy zzt(byte[] byArray) {
        return new zzgw(byArray, 0, byArray.length);
    }

    public static int zzu(int n) {
        return zzgy.zzw(n << 3);
    }

    public static int zzv(int n) {
        if (n < 0) return 10;
        return zzgy.zzw(n);
    }

    public static int zzw(int n) {
        if ((n & 0xFFFFFF80) == 0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0) {
            return 2;
        }
        if ((0xFFE00000 & n) == 0) {
            return 3;
        }
        if ((n & 0xF0000000) != 0) return 5;
        return 4;
    }

    public static int zzx(long l) {
        int n;
        if ((0xFFFFFFFFFFFFFF80L & l) == 0L) {
            return 1;
        }
        if (l < 0L) {
            return 10;
        }
        if ((0xFFFFFFF800000000L & l) != 0L) {
            l >>>= 28;
            n = 6;
        } else {
            n = 2;
        }
        int n2 = n;
        long l2 = l;
        if ((0xFFFFFFFFFFE00000L & l) != 0L) {
            n2 = n + 2;
            l2 = l >>> 14;
        }
        n = n2;
        if ((l2 & 0xFFFFFFFFFFFFC000L) == 0L) return n;
        n = n2 + 1;
        return n;
    }

    public static int zzy(String string) {
        int n;
        try {
            n = zzkk.zzc((CharSequence)string);
        }
        catch (zzkj zzkj2) {
            n = string.getBytes(zzhz.zza).length;
        }
        return zzgy.zzw(n) + n;
    }

    public static int zzz(zzie zzie2) {
        int n = zzie2.zza();
        return zzgy.zzw(n) + n;
    }

    public final void zzC() {
        if (this.zzs() != 0) throw new IllegalStateException("Did not write as much data as expected.");
    }

    final void zzD(String object, zzkj zzkj2) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzkj2);
        object = ((String)object).getBytes(zzhz.zza);
        try {
            int n = ((Object)object).length;
            this.zzl(n);
            this.zzq((byte[])object, 0, n);
            return;
        }
        catch (zzgx zzgx2) {
            throw zzgx2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgx((Throwable)indexOutOfBoundsException);
        }
    }

    public abstract void zza(int var1, int var2) throws IOException;

    public abstract void zzb(int var1, int var2) throws IOException;

    public abstract void zzc(int var1, int var2) throws IOException;

    public abstract void zzd(int var1, int var2) throws IOException;

    public abstract void zze(int var1, long var2) throws IOException;

    public abstract void zzf(int var1, long var2) throws IOException;

    public abstract void zzg(int var1, boolean var2) throws IOException;

    public abstract void zzh(int var1, String var2) throws IOException;

    public abstract void zzi(int var1, zzgr var2) throws IOException;

    public abstract void zzj(byte var1) throws IOException;

    public abstract void zzk(int var1) throws IOException;

    public abstract void zzl(int var1) throws IOException;

    public abstract void zzm(int var1) throws IOException;

    public abstract void zzn(long var1) throws IOException;

    public abstract void zzo(long var1) throws IOException;

    public abstract void zzq(byte[] var1, int var2, int var3) throws IOException;

    public abstract int zzs();
}
