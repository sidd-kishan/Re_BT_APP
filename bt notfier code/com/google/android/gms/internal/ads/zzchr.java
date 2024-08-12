/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzchs
 *  com.google.android.gms.internal.ads.zzfrz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzchs;
import com.google.android.gms.internal.ads.zzfrz;

final class zzchr
implements zzfrz {
    final zzchp zza;
    final zzchn zzb;

    zzchr(zzchs zzchs2, zzchp zzchp2, zzchn zzchn2) {
        this.zza = zzchp2;
        this.zzb = zzchn2;
    }

    public final void zza(Throwable throwable) {
        this.zzb.zza();
    }

    public final void zzb(Object object) {
        this.zza.zza(object);
    }
}
