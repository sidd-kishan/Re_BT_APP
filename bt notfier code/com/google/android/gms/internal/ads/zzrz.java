/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 *  com.google.android.gms.internal.ads.zzry
 *  com.google.android.gms.internal.ads.zzsa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;
import com.google.android.gms.internal.ads.zzry;
import com.google.android.gms.internal.ads.zzsa;

final class zzrz
implements zzot {
    final zzsa zza;

    /* synthetic */ zzrz(zzsa zzsa2, zzry zzry2) {
        this.zza = zzsa2;
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        long l2 = zzsa.zzc((zzsa)this.zza).zzi(l);
        zzou zzou2 = new zzou(l, zzamq.zzy((long)(-30000L + (zzsa.zza((zzsa)this.zza) + l2 * (zzsa.zzb((zzsa)this.zza) - zzsa.zza((zzsa)this.zza)) / zzsa.zzd((zzsa)this.zza))), (long)zzsa.zza((zzsa)this.zza), (long)(zzsa.zzb((zzsa)this.zza) - 1L)));
        return new zzor(zzou2, zzou2);
    }

    public final long zzg() {
        return zzsa.zzc((zzsa)this.zza).zzh(zzsa.zzd((zzsa)this.zza));
    }
}
