/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapv
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzave;

public final class zzapm
implements zzapv {
    public final int[] zza;
    public final long[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    private final long zze;

    public zzapm(int[] nArray, long[] lArray, long[] lArray2, long[] lArray3) {
        this.zza = nArray;
        this.zzb = lArray;
        this.zzc = lArray2;
        this.zzd = lArray3;
        int n = nArray.length;
        if (n > 0) {
            this.zze = lArray2[--n] + lArray3[n];
            return;
        }
        this.zze = 0L;
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long l) {
        return this.zzb[zzave.zzh((long[])this.zzd, (long)l, (boolean)true, (boolean)true)];
    }
}
