/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;

public final class zzom
implements zzot {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzom(long[] lArray, long[] lArray2, long l) {
        int n = lArray.length;
        int n2 = lArray2.length;
        boolean bl = n == n2;
        zzakt.zza((boolean)bl);
        bl = n2 > 0;
        this.zzd = bl;
        if (bl && lArray2[0] > 0L) {
            n = n2 + 1;
            long[] lArray3 = new long[n];
            this.zza = lArray3;
            this.zzb = new long[n];
            System.arraycopy(lArray, 0, lArray3, 1, n2);
            System.arraycopy(lArray2, 0, this.zzb, 1, n2);
        } else {
            this.zza = lArray;
            this.zzb = lArray2;
        }
        this.zzc = l;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final zzor zzf(long l) {
        if (!this.zzd) {
            zzou zzou2 = zzou.zza;
            return new zzor(zzou2, zzou2);
        }
        int n = zzamq.zzD((long[])this.zzb, (long)l, (boolean)true, (boolean)true);
        zzou zzou3 = new zzou(this.zzb[n], this.zza[n]);
        if (zzou3.zzb == l) return new zzor(zzou3, zzou3);
        long[] lArray = this.zzb;
        if (n != lArray.length - 1) return new zzor(zzou3, new zzou(lArray[++n], this.zza[n]));
        return new zzor(zzou3, zzou3);
    }

    public final long zzg() {
        return this.zzc;
    }
}
