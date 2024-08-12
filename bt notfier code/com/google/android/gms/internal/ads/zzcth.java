/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcti
 *  com.google.android.gms.internal.ads.zzctl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcti;
import com.google.android.gms.internal.ads.zzctl;

final class zzcth
implements Runnable {
    private final zzcti zza;

    zzcth(zzcti zzcti2) {
        this.zza = zzcti2;
    }

    @Override
    public final void run() {
        zzctl.zzb((zzctl)this.zza.zza).zzh();
    }
}
