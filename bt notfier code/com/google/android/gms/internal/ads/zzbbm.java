/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbbk
 *  com.google.android.gms.internal.ads.zzbbl
 *  com.google.android.gms.internal.ads.zzggc
 *  com.google.android.gms.internal.ads.zzggd
 *  com.google.android.gms.internal.ads.zzgge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzbbl;
import com.google.android.gms.internal.ads.zzggc;
import com.google.android.gms.internal.ads.zzggd;
import com.google.android.gms.internal.ads.zzgge;

public final class zzbbm
extends Enum<zzbbm>
implements zzggc {
    public static final /* enum */ zzbbm zza;
    public static final /* enum */ zzbbm zzb;
    public static final /* enum */ zzbbm zzc;
    public static final /* enum */ zzbbm zzd;
    public static final /* enum */ zzbbm zze;
    public static final /* enum */ zzbbm zzf;
    private static final zzggd<zzbbm> zzg;
    private static final zzbbm[] zzi;
    private final int zzh;

    static {
        zzbbm zzbbm2;
        zza = new zzbbm(0);
        zzb = new zzbbm(1);
        zzc = new zzbbm(2);
        zzd = new zzbbm(3);
        zze = new zzbbm(4);
        zzf = zzbbm2 = new zzbbm(5);
        zzi = new zzbbm[]{zza, zzb, zzc, zzd, zze, zzbbm2};
        zzg = new zzbbk();
    }

    private zzbbm(int n2) {
        this.zzh = n2;
    }

    public static zzbbm[] values() {
        return (zzbbm[])zzi.clone();
    }

    public static zzbbm zzb(int n) {
        if (n == 0) return zza;
        if (n == 1) return zzb;
        if (n == 2) return zzc;
        if (n == 3) return zzd;
        if (n == 4) return zze;
        if (n == 5) return zzf;
        return null;
    }

    public static zzgge zzc() {
        return zzbbl.zza;
    }

    public final String toString() {
        return Integer.toString(this.zzh);
    }

    public final int zza() {
        return this.zzh;
    }
}
