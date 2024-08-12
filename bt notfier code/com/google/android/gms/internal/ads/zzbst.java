/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbsm
 *  com.google.android.gms.internal.ads.zzcny
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzcny;

final class zzbst
implements zzcny {
    private final zzbsm zza;

    private zzbst(zzbsm zzbsm2) {
        this.zza = zzbsm2;
    }

    static zzcny zza(zzbsm zzbsm2) {
        return new zzbst(zzbsm2);
    }

    public final void zzb() {
        this.zza.zza();
    }
}
