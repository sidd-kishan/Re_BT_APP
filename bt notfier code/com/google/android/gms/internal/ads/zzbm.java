/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzcz
 *  com.google.android.gms.internal.ads.zzda
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzcz;
import com.google.android.gms.internal.ads.zzda;

final class zzbm
implements zzalj {
    private final zzcz zza;
    private final int zzb;
    private final long zzc;

    zzbm(zzcz zzcz2, int n, long l) {
        this.zza = zzcz2;
        this.zzb = n;
        this.zzc = l;
    }

    public final void zza(Object object) {
        zzcz zzcz2 = this.zza;
        int n = this.zzb;
        long l = this.zzc;
        ((zzda)object).zzj(zzcz2, n, l);
    }
}
