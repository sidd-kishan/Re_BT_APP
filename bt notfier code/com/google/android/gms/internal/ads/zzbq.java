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

final class zzbq
implements zzalj {
    private final zzcz zza;
    private final Object zzb;
    private final long zzc;

    zzbq(zzcz zzcz2, Object object, long l) {
        this.zza = zzcz2;
        this.zzb = object;
        this.zzc = l;
    }

    public final void zza(Object object) {
        zzcz zzcz2 = this.zza;
        Object object2 = this.zzb;
        long l = this.zzc;
        ((zzda)object).zzk(zzcz2, object2, l);
    }
}
