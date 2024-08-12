/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdji
 *  com.google.android.gms.internal.ads.zzelq
 *  com.google.android.gms.internal.ads.zzelx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdji;
import com.google.android.gms.internal.ads.zzelq;
import com.google.android.gms.internal.ads.zzelx;

final class zzelp
implements zzelx<zzdji> {
    final zzelq zza;

    zzelp(zzelq zzelq2) {
        this.zza = zzelq2;
    }

    public final void zza() {
        zzelq zzelq2 = this.zza;
        synchronized (zzelq2) {
            zzelq.zzb((zzelq)this.zza, null);
            return;
        }
    }
}
