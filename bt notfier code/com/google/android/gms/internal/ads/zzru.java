/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzrv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzrv;

public final class zzru {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzafv zzf;
    public final int zzg;
    public final long[] zzh;
    public final long[] zzi;
    public final int zzj;
    private final zzrv[] zzk;

    public zzru(int n, int n2, long l, long l2, long l3, zzafv zzafv2, int n3, zzrv[] zzrvArray, int n4, long[] lArray, long[] lArray2) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = l;
        this.zzd = l2;
        this.zze = l3;
        this.zzf = zzafv2;
        this.zzg = n3;
        this.zzk = zzrvArray;
        this.zzj = n4;
        this.zzh = lArray;
        this.zzi = lArray2;
    }

    public final zzrv zza(int n) {
        zzrv[] zzrvArray = this.zzk;
        if (zzrvArray != null) return zzrvArray[n];
        return null;
    }
}
