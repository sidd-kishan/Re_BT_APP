/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzuw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzuw;

final class zzuz
implements zzot {
    private final zzuw zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzuz(zzuw zzuw2, int n, long l, long l2) {
        this.zza = zzuw2;
        this.zzb = n;
        this.zzc = l;
        this.zzd = l = (l2 - l) / (long)zzuw2.zzd;
        this.zze = this.zza(l);
    }

    private final long zza(long l) {
        return zzamq.zzH((long)(l * (long)this.zzb), (long)1000000L, (long)this.zza.zzc);
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        long l2 = zzamq.zzy((long)((long)this.zza.zzc * l / ((long)this.zzb * 1000000L)), (long)0L, (long)(this.zzd - 1L));
        long l3 = this.zzc;
        int n = this.zza.zzd;
        long l4 = this.zza(l2);
        zzou zzou2 = new zzou(l4, l3 + (long)n * l2);
        if (l4 >= l) return new zzor(zzou2, zzou2);
        if (l2 == this.zzd - 1L) {
            return new zzor(zzou2, zzou2);
        }
        l4 = l2 + 1L;
        l = this.zzc;
        n = this.zza.zzd;
        return new zzor(zzou2, new zzou(this.zza(l4), l + l4 * (long)n));
    }

    public final long zzg() {
        return this.zze;
    }
}
