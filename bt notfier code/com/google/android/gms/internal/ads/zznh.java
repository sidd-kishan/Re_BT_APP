/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;

public final class zznh {
    private final long zza;
    private final long zzb;
    private final long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    protected zznh(long l, long l2, long l3, long l4, long l5, long l6, long l7) {
        this.zza = l;
        this.zzb = l2;
        this.zzd = 0L;
        this.zze = l4;
        this.zzf = l5;
        this.zzg = l6;
        this.zzc = l7;
        this.zzh = zznh.zza(l2, 0L, l4, l5, l6, l7);
    }

    protected static long zza(long l, long l2, long l3, long l4, long l5, long l6) {
        if (l4 + 1L >= l5) return l4;
        if (1L + l2 >= l3) {
            return l4;
        }
        l = (long)((float)(l - l2) * ((float)(l5 - l4) / (float)(l3 - l2)));
        return zzamq.zzy((long)(l4 + l - l6 - l / 20L), (long)l4, (long)(-1L + l5));
    }

    static /* synthetic */ long zzb(zznh zznh2) {
        return zznh2.zzf;
    }

    static /* synthetic */ long zzc(zznh zznh2) {
        return zznh2.zzg;
    }

    static /* synthetic */ long zzd(zznh zznh2) {
        return zznh2.zzb;
    }

    static /* synthetic */ long zze(zznh zznh2) {
        return zznh2.zza;
    }

    static /* synthetic */ void zzf(zznh zznh2, long l, long l2) {
        zznh2.zzd = l;
        zznh2.zzf = l2;
        zznh2.zzi();
    }

    static /* synthetic */ void zzg(zznh zznh2, long l, long l2) {
        zznh2.zze = l;
        zznh2.zzg = l2;
        zznh2.zzi();
    }

    static /* synthetic */ long zzh(zznh zznh2) {
        return zznh2.zzh;
    }

    private final void zzi() {
        this.zzh = zznh.zza(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
