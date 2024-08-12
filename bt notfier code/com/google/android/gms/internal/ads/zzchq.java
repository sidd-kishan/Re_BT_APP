/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchs
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchs;
import com.google.android.gms.internal.ads.zzfrz;

final class zzchq
implements zzfrz {
    final zzchs zza;

    zzchq(zzchs zzchs2) {
        this.zza = zzchs2;
    }

    public final void zza(Throwable throwable) {
        zzchs.zze((zzchs)this.zza).set(-1);
    }

    public final void zzb(Object object) {
        zzchs.zze((zzchs)this.zza).set(1);
    }
}
