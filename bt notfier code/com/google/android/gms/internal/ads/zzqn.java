/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzakb
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzqs
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzakb;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzqs;

final class zzqn
implements zzqs {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzqn(long[] lArray, long[] lArray2, long l) {
        this.zza = lArray;
        this.zzb = lArray2;
        if (l == -9223372036854775807L) {
            l = zzadx.zzb((long)lArray2[lArray2.length - 1]);
        }
        this.zzc = l;
    }

    public static zzqn zza(long l, zzakb zzakb2, long l2) {
        int n = zzakb2.zzd.length;
        int n2 = n + 1;
        long[] lArray = new long[n2];
        long[] lArray2 = new long[n2];
        lArray[0] = l;
        long l3 = 0L;
        lArray2[0] = 0L;
        n2 = 1;
        long l4 = l;
        l = l3;
        while (n2 <= n) {
            int n3 = n2 - 1;
            lArray[n2] = l4 += (long)(zzakb2.zzb + zzakb2.zzd[n3]);
            lArray2[n2] = l += (long)(zzakb2.zzc + zzakb2.zze[n3]);
            ++n2;
        }
        return new zzqn(lArray, lArray2, l2);
    }

    private static Pair<Long, Long> zzd(long l, long[] lArray, long[] lArray2) {
        double d;
        double d2;
        int n = zzamq.zzD((long[])lArray, (long)l, (boolean)true, (boolean)true);
        long l2 = lArray[n];
        long l3 = lArray2[n];
        if (++n == lArray.length) {
            return Pair.create((Object)l2, (Object)l3);
        }
        long l4 = lArray[n];
        long l5 = lArray2[n];
        if (l4 == l2) {
            d2 = 0.0;
        } else {
            d = l;
            d2 = l2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = l4 - l2;
            Double.isNaN(d3);
            d2 = (d - d2) / d3;
        }
        d = l5 - l3;
        Double.isNaN(d);
        return Pair.create((Object)l, (Object)((long)(d2 * d) + l3));
    }

    public final long zzb(long l) {
        return zzadx.zzb((long)((Long)zzqn.zzd((long)l, (long[])this.zza, (long[])this.zzb).second));
    }

    public final long zzc() {
        return -1L;
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        zzou zzou2 = zzqn.zzd(zzadx.zza((long)zzamq.zzy((long)l, (long)0L, (long)this.zzc)), this.zzb, this.zza);
        zzou2 = new zzou(zzadx.zzb((long)((Long)zzou2.first)), ((Long)zzou2.second).longValue());
        return new zzor(zzou2, zzou2);
    }

    public final long zzg() {
        return this.zzc;
    }
}
