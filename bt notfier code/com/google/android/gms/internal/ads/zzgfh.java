/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgem
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfe
 *  com.google.android.gms.internal.ads.zzgff
 *  com.google.android.gms.internal.ads.zzgfg
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggq
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgiy
 *  com.google.android.gms.internal.ads.zzgjc
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgem;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfe;
import com.google.android.gms.internal.ads.zzgff;
import com.google.android.gms.internal.ads.zzgfg;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggq;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgiy;
import com.google.android.gms.internal.ads.zzgjc;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgfh
extends zzgem {
    private static final Logger zzb = Logger.getLogger(zzgfh.class.getName());
    private static final boolean zzc = zzgiy.zza();
    zzgfi zza;

    private zzgfh() {
    }

    /* synthetic */ zzgfh(zzgff zzgff2) {
    }

    public static int zzA(zzggq zzggq2) {
        int n = zzggq2.zza();
        return zzgfh.zzx(n) + n;
    }

    public static int zzB(zzgex zzgex2) {
        int n = zzgex2.zzc();
        return zzgfh.zzx(n) + n;
    }

    static int zzC(zzghi zzghi2, zzghz zzghz2) {
        int n;
        zzghi2 = (zzgeg)zzghi2;
        int n2 = n = zzghi2.zzap();
        if (n != -1) return zzgfh.zzx(n2) + n2;
        n2 = zzghz2.zze((Object)zzghi2);
        zzghi2.zzaq(n2);
        return zzgfh.zzx(n2) + n2;
    }

    @Deprecated
    static int zzF(int n, zzghi zzghi2, zzghz zzghz2) {
        int n2;
        int n3 = zzgfh.zzx(n << 3);
        zzghi2 = (zzgeg)zzghi2;
        n = n2 = zzghi2.zzap();
        if (n2 != -1) return n3 + n3 + n;
        n = zzghz2.zze((Object)zzghi2);
        zzghi2.zzaq(n);
        return n3 + n3 + n;
    }

    static /* synthetic */ boolean zzt() {
        return zzc;
    }

    public static zzgfh zzu(byte[] byArray) {
        return new zzgfe(byArray, 0, byArray.length);
    }

    public static int zzv(int n) {
        return zzgfh.zzx(n << 3);
    }

    public static int zzw(int n) {
        if (n < 0) return 10;
        return zzgfh.zzx(n);
    }

    public static int zzx(int n) {
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

    public static int zzy(long l) {
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

    public static int zzz(String string) {
        int n;
        try {
            n = zzgjd.zzg((CharSequence)string);
        }
        catch (zzgjc zzgjc2) {
            n = string.getBytes(zzggk.zza).length;
        }
        return zzgfh.zzx(n) + n;
    }

    public final void zzD() {
        if (this.zzs() != 0) throw new IllegalStateException("Did not write as much data as expected.");
    }

    final void zzE(String object, zzgjc zzgjc2) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzgjc2);
        object = ((String)object).getBytes(zzggk.zza);
        try {
            int n = ((Object)object).length;
            this.zzl(n);
            this.zzq((byte[])object, 0, n);
            return;
        }
        catch (zzgfg zzgfg2) {
            throw zzgfg2;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new zzgfg((Throwable)indexOutOfBoundsException);
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

    public abstract void zzi(int var1, zzgex var2) throws IOException;

    public abstract void zzj(byte var1) throws IOException;

    public abstract void zzk(int var1) throws IOException;

    public abstract void zzl(int var1) throws IOException;

    public abstract void zzm(int var1) throws IOException;

    public abstract void zzn(long var1) throws IOException;

    public abstract void zzo(long var1) throws IOException;

    public abstract void zzq(byte[] var1, int var2, int var3) throws IOException;

    public abstract int zzs();
}
