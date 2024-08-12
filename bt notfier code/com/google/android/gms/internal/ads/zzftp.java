/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgat
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgat;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgex;

public final class zzftp {
    private final zzgau zza;

    private zzftp(zzgau zzgau2) {
        this.zza = zzgau2;
    }

    public static zzftp zzc(String string, byte[] byArray, int n) {
        zzgat zzgat2 = zzgau.zzd();
        zzgat2.zza(string);
        zzgat2.zzb(zzgex.zzt((byte[])byArray));
        n = --n != 0 ? (n != 1 ? 5 : 4) : 3;
        zzgat2.zzc(n);
        return new zzftp((zzgau)zzgat2.zzah());
    }

    public final String zza() {
        return this.zza.zza();
    }

    public final byte[] zzb() {
        return this.zza.zzc().zzz();
    }

    public final int zzd() {
        int n = this.zza.zzi() - 2;
        int n2 = 1;
        if (n == 1) return n2;
        n2 = 2;
        if (n == 2) return n2;
        n2 = 3;
        if (n == 3) return n2;
        if (n != 4) throw new IllegalArgumentException("Unknown output prefix type");
        return 4;
    }
}
