/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzof
 *  com.google.android.gms.internal.ads.zzog
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzsh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzof;
import com.google.android.gms.internal.ads.zzog;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzsh;

final class zzsb
implements zzsh {
    private final zzoh zza;
    private final zzog zzb;
    private long zzc;
    private long zzd;

    public zzsb(zzoh zzoh2, zzog zzog2) {
        this.zza = zzoh2;
        this.zzb = zzog2;
        this.zzc = -1L;
        this.zzd = -1L;
    }

    public final void zza(long l) {
        this.zzc = l;
    }

    public final long zze(zznv zznv2) {
        long l = this.zzd;
        if (l < 0L) return -1L;
        this.zzd = -1L;
        return -(l + 2L);
    }

    public final void zzf(long l) {
        long[] lArray = this.zzb.zza;
        this.zzd = lArray[zzamq.zzD((long[])lArray, (long)l, (boolean)true, (boolean)true)];
    }

    public final zzot zzg() {
        boolean bl = this.zzc != -1L;
        zzakt.zzd((boolean)bl);
        return new zzof(this.zza, this.zzc);
    }
}
