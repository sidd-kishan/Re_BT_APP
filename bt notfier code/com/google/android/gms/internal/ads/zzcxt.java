/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcxu
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcxu;
import com.google.android.gms.internal.ads.zzfrz;

final class zzcxt
implements zzfrz<zzcxg> {
    final zzfrz zza;
    final zzcxu zzb;

    zzcxt(zzcxu zzcxu2, zzfrz zzfrz2) {
        this.zzb = zzcxu2;
        this.zza = zzfrz2;
    }

    public final void zza(Throwable throwable) {
        zzcxu.zzd((zzcxu)this.zzb);
        this.zza.zza(throwable);
    }
}
