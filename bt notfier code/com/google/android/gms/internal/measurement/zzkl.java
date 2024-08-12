/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzkm
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkm;

public final class zzkl
extends Enum<zzkl> {
    public static final /* enum */ zzkl zza;
    public static final /* enum */ zzkl zzb;
    public static final /* enum */ zzkl zzc;
    public static final /* enum */ zzkl zzd;
    public static final /* enum */ zzkl zze;
    public static final /* enum */ zzkl zzf;
    public static final /* enum */ zzkl zzg;
    public static final /* enum */ zzkl zzh;
    public static final /* enum */ zzkl zzi;
    public static final /* enum */ zzkl zzj;
    public static final /* enum */ zzkl zzk;
    public static final /* enum */ zzkl zzl;
    public static final /* enum */ zzkl zzm;
    public static final /* enum */ zzkl zzn;
    public static final /* enum */ zzkl zzo;
    public static final /* enum */ zzkl zzp;
    public static final /* enum */ zzkl zzq;
    public static final /* enum */ zzkl zzr;
    private static final zzkl[] zzt;
    private final zzkm zzs;

    static {
        zzkl zzkl2;
        zza = new zzkl(zzkm.zzd, 1);
        zzb = new zzkl(zzkm.zzc, 5);
        zzc = new zzkl(zzkm.zzb, 0);
        zzd = new zzkl(zzkm.zzb, 0);
        zze = new zzkl(zzkm.zza, 0);
        zzf = new zzkl(zzkm.zzb, 1);
        zzg = new zzkl(zzkm.zza, 5);
        zzh = new zzkl(zzkm.zze, 0);
        zzi = new zzkl(zzkm.zzf, 2);
        zzj = new zzkl(zzkm.zzi, 3);
        zzk = new zzkl(zzkm.zzi, 2);
        zzl = new zzkl(zzkm.zzg, 2);
        zzm = new zzkl(zzkm.zza, 0);
        zzn = new zzkl(zzkm.zzh, 0);
        zzo = new zzkl(zzkm.zza, 5);
        zzp = new zzkl(zzkm.zzb, 1);
        zzq = new zzkl(zzkm.zza, 0);
        zzr = zzkl2 = new zzkl(zzkm.zzb, 0);
        zzt = new zzkl[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzkl2};
    }

    private zzkl(zzkm zzkm2, int n2) {
        this.zzs = zzkm2;
    }

    public static zzkl[] values() {
        return (zzkl[])zzt.clone();
    }

    public final zzkm zza() {
        return this.zzs;
    }
}
