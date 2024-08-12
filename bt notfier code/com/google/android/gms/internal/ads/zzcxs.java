/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxn
 *  com.google.android.gms.internal.ads.zzcxu
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxn;
import com.google.android.gms.internal.ads.zzcxu;
import com.google.android.gms.internal.ads.zzfrz;

final class zzcxs
implements zzfrz<zzcxn> {
    final zzfrz zza;
    final zzcxu zzb;

    zzcxs(zzcxu zzcxu2, zzfrz zzfrz2) {
        this.zzb = zzcxu2;
        this.zza = zzfrz2;
    }

    public final void zza(Throwable throwable) {
        this.zza.zza(throwable);
        zzcxu.zzd((zzcxu)this.zzb);
    }
}
