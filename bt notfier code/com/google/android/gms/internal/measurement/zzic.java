/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;

public final class zzic
extends Enum<zzic> {
    public static final /* enum */ zzic zza;
    public static final /* enum */ zzic zzb;
    public static final /* enum */ zzic zzc;
    public static final /* enum */ zzic zzd;
    public static final /* enum */ zzic zze;
    public static final /* enum */ zzic zzf;
    public static final /* enum */ zzic zzg;
    public static final /* enum */ zzic zzh;
    public static final /* enum */ zzic zzi;
    public static final /* enum */ zzic zzj;
    private static final zzic[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        zzic zzic2;
        zza = new zzic(Void.class, Void.class, null);
        zzb = new zzic(Integer.TYPE, Integer.class, 0);
        zzc = new zzic(Long.TYPE, Long.class, 0L);
        zzd = new zzic(Float.TYPE, Float.class, Float.valueOf(0.0f));
        zze = new zzic(Double.TYPE, Double.class, 0.0);
        zzf = new zzic(Boolean.TYPE, Boolean.class, false);
        zzg = new zzic(String.class, String.class, "");
        zzh = new zzic(zzgr.class, zzgr.class, zzgr.zzb);
        zzi = new zzic(Integer.TYPE, Integer.class, null);
        zzj = zzic2 = new zzic(Object.class, Object.class, null);
        zzn = new zzic[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzic2};
    }

    private zzic(Class<?> clazz, Class<?> clazz2, Object object) {
        this.zzk = clazz;
        this.zzl = clazz2;
        this.zzm = object;
    }

    public static zzic[] values() {
        return (zzic[])zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
