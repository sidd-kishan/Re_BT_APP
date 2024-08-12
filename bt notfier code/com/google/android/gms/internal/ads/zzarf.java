/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;

final class zzarf {
    public final int zza;
    public final long[] zzb;
    public final int[] zzc;
    public final int zzd;
    public final long[] zze;
    public final int[] zzf;

    public zzarf(long[] lArray, int[] nArray, int n, long[] lArray2, int[] nArray2) {
        int n2 = lArray2.length;
        int n3 = nArray.length;
        boolean bl = true;
        boolean bl2 = n3 == n2;
        zzaup.zza((boolean)bl2);
        n3 = lArray.length;
        bl2 = n3 == n2;
        zzaup.zza((boolean)bl2);
        bl2 = nArray2.length == n2 ? bl : false;
        zzaup.zza((boolean)bl2);
        this.zzb = lArray;
        this.zzc = nArray;
        this.zzd = n;
        this.zze = lArray2;
        this.zzf = nArray2;
        this.zza = n3;
    }

    public final int zza(long l) {
        int n = zzave.zzh((long[])this.zze, (long)l, (boolean)true, (boolean)false);
        while (n >= 0) {
            if ((this.zzf[n] & 1) != 0) {
                return n;
            }
            --n;
        }
        return -1;
    }

    public final int zzb(long l) {
        int n = zzave.zzi((long[])this.zze, (long)l, (boolean)true, (boolean)false);
        while (n < this.zze.length) {
            if ((this.zzf[n] & 1) != 0) {
                return n;
            }
            ++n;
        }
        return -1;
    }
}
