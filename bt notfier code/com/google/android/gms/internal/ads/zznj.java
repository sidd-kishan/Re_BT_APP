/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zznj {
    public static final zznj zza = new zznj(-3, -9223372036854775807L, -1L);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zznj(int n, long l, long l2) {
        this.zzb = n;
        this.zzc = l;
        this.zzd = l2;
    }

    static /* synthetic */ int zza(zznj zznj2) {
        return zznj2.zzb;
    }

    static /* synthetic */ long zzb(zznj zznj2) {
        return zznj2.zzc;
    }

    static /* synthetic */ long zzc(zznj zznj2) {
        return zznj2.zzd;
    }

    public static zznj zzd(long l, long l2) {
        return new zznj(-1, l, l2);
    }

    public static zznj zze(long l, long l2) {
        return new zznj(-2, l, l2);
    }

    public static zznj zzf(long l) {
        return new zznj(0, -9223372036854775807L, l);
    }
}
