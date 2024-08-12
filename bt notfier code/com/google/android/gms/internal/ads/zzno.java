/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;

public class zzno
implements zzot {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzno(long l, long l2, int n, int n2, boolean bl) {
        this.zza = l;
        this.zzb = l2;
        int n3 = n2;
        if (n2 == -1) {
            n3 = 1;
        }
        this.zzc = n3;
        this.zze = n;
        if (l == -1L) {
            this.zzd = -1L;
            l = -9223372036854775807L;
        } else {
            this.zzd = l - l2;
            l = zzno.zzb(l, l2, n);
        }
        this.zzf = l;
    }

    private static long zzb(long l, long l2, int n) {
        return Math.max(0L, l - l2) * 8000000L / (long)n;
    }

    public final long zza(long l) {
        return zzno.zzb(l, this.zzb, this.zze);
    }

    public final boolean zze() {
        if (this.zzd != -1L) return true;
        return false;
    }

    public final zzor zzf(long l) {
        long l2;
        long l3 = this.zzd;
        if (l3 == -1L) {
            zzou zzou2 = new zzou(0L, this.zzb);
            return new zzor(zzou2, zzou2);
        }
        int n = this.zze;
        long l4 = this.zzc;
        long l5 = l2 = (long)n * l / 8000000L / l4 * l4;
        if (l3 != -1L) {
            l5 = Math.min(l2, l3 - l4);
        }
        l5 = Math.max(l5, 0L);
        l5 = this.zzb + l5;
        l2 = this.zza(l5);
        zzou zzou3 = new zzou(l2, l5);
        if (this.zzd == -1L) return new zzor(zzou3, zzou3);
        if (l2 >= l) return new zzor(zzou3, zzou3);
        l = l5 + (long)this.zzc;
        if (l < this.zza) return new zzor(zzou3, new zzou(this.zza(l), l));
        return new zzor(zzou3, zzou3);
    }

    public final long zzg() {
        return this.zzf;
    }
}
