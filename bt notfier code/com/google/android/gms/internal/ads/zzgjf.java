/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;

public final class zzgjf
extends Enum<zzgjf> {
    public static final /* enum */ zzgjf zza;
    public static final /* enum */ zzgjf zzb;
    public static final /* enum */ zzgjf zzc;
    public static final /* enum */ zzgjf zzd;
    public static final /* enum */ zzgjf zze;
    public static final /* enum */ zzgjf zzf;
    public static final /* enum */ zzgjf zzg;
    public static final /* enum */ zzgjf zzh;
    public static final /* enum */ zzgjf zzi;
    private static final zzgjf[] zzk;
    private final Object zzj;

    static {
        zzgjf zzgjf2;
        zza = new zzgjf(0);
        zzb = new zzgjf(0L);
        zzc = new zzgjf(Float.valueOf(0.0f));
        zzd = new zzgjf(0.0);
        zze = new zzgjf(false);
        zzf = new zzgjf("");
        zzg = new zzgjf(zzgex.zzb);
        zzh = new zzgjf(null);
        zzi = zzgjf2 = new zzgjf(null);
        zzk = new zzgjf[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzgjf2};
    }

    private zzgjf(Object object) {
        this.zzj = object;
    }

    public static zzgjf[] values() {
        return (zzgjf[])zzk.clone();
    }
}
