/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;

public final class zzkm
extends Enum<zzkm> {
    public static final /* enum */ zzkm zza;
    public static final /* enum */ zzkm zzb;
    public static final /* enum */ zzkm zzc;
    public static final /* enum */ zzkm zzd;
    public static final /* enum */ zzkm zze;
    public static final /* enum */ zzkm zzf;
    public static final /* enum */ zzkm zzg;
    public static final /* enum */ zzkm zzh;
    public static final /* enum */ zzkm zzi;
    private static final zzkm[] zzk;
    private final Object zzj;

    static {
        zzkm zzkm2;
        zza = new zzkm(0);
        zzb = new zzkm(0L);
        zzc = new zzkm(Float.valueOf(0.0f));
        zzd = new zzkm(0.0);
        zze = new zzkm(false);
        zzf = new zzkm("");
        zzg = new zzkm(zzgr.zzb);
        zzh = new zzkm(null);
        zzi = zzkm2 = new zzkm(null);
        zzk = new zzkm[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzkm2};
    }

    private zzkm(Object object) {
        this.zzj = object;
    }

    public static zzkm[] values() {
        return (zzkm[])zzk.clone();
    }
}
