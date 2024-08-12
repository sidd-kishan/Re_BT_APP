/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;

public final class zzggo
extends Enum<zzggo> {
    public static final /* enum */ zzggo zza;
    public static final /* enum */ zzggo zzb;
    public static final /* enum */ zzggo zzc;
    public static final /* enum */ zzggo zzd;
    public static final /* enum */ zzggo zze;
    public static final /* enum */ zzggo zzf;
    public static final /* enum */ zzggo zzg;
    public static final /* enum */ zzggo zzh;
    public static final /* enum */ zzggo zzi;
    public static final /* enum */ zzggo zzj;
    private static final zzggo[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        zzggo zzggo2;
        zza = new zzggo(Void.class, Void.class, null);
        zzb = new zzggo(Integer.TYPE, Integer.class, 0);
        zzc = new zzggo(Long.TYPE, Long.class, 0L);
        zzd = new zzggo(Float.TYPE, Float.class, Float.valueOf(0.0f));
        zze = new zzggo(Double.TYPE, Double.class, 0.0);
        zzf = new zzggo(Boolean.TYPE, Boolean.class, false);
        zzg = new zzggo(String.class, String.class, "");
        zzh = new zzggo(zzgex.class, zzgex.class, zzgex.zzb);
        zzi = new zzggo(Integer.TYPE, Integer.class, null);
        zzj = zzggo2 = new zzggo(Object.class, Object.class, null);
        zzn = new zzggo[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzggo2};
    }

    private zzggo(Class<?> clazz, Class<?> clazz2, Object object) {
        this.zzk = clazz;
        this.zzl = clazz2;
        this.zzm = object;
    }

    public static zzggo[] values() {
        return (zzggo[])zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
